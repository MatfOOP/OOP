/*
 * Copyright (c) 2008, 2011 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ensemble.samples.charts.area;

import ensemble.Sample;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/** 
 * An advanced area chart with sound and animation.
 *
 * @see javafx.scene.chart.AreaChart
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.NumberAxis
 * @see javafx.scene.chart.XYChart
 * @see javafx.scene.media.AudioSpectrumListener
 * @see javafx.scene.media.Media
 * @see javafx.scene.media.MediaPlayer
 */
public class AdvAreaAudioChartSample extends Sample {
    private XYChart.Data<Number,Number>[] series1Data;
    private AudioSpectrumListener audioSpectrumListener;

 //   private static final String AUDIO_URI = System.getProperty("demo.audio.url","http://sun.edgeboss.net/download/sun/transfer/oow2010.flv");
    private static final String AUDIO_URI = System.getProperty("demo.audio.url","http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
    private static MediaPlayer audioMediaPlayer;
    private static final boolean PLAY_AUDIO = Boolean.parseBoolean(System.getProperty("demo.play.audio","true"));

    public AdvAreaAudioChartSample() {
        getChildren().add(createChart());
        audioSpectrumListener = new AudioSpectrumListener() {
            @Override public void spectrumDataUpdate(double timestamp, double duration,
                    float[] magnitudes, float[] phases) {
                for (int i = 0; i < series1Data.length; i++) {
                    series1Data[i].setYValue(magnitudes[i] + 60);
                }
            }
        };
    }

    @Override public void play() {
        this.startAudio();
    }

    @Override public void stop() {
        this.stopAudio();
    }

    protected AreaChart<Number,Number> createChart() {
        final NumberAxis xAxis = new NumberAxis(0,128,8);
        final NumberAxis yAxis = new NumberAxis(0,50,10);
        final AreaChart<Number,Number> ac = new AreaChart<Number,Number>(xAxis,yAxis);
        // setup chart
        ac.setId("audioAreaDemo");
        ac.setLegendVisible(false);
        ac.setTitle("Live Audio Spectrum Data");
        ac.setAnimated(false);
        xAxis.setLabel("Frequency Bands");
        yAxis.setLabel("Magnitudes");
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,null,"dB"));
        // add starting data
        XYChart.Series<Number,Number> series = new XYChart.Series<Number,Number>();
        series.setName("Audio Spectrum");
        //noinspection unchecked
        series1Data = new XYChart.Data[(int)xAxis.getUpperBound()];
        for (int i=0; i<series1Data.length; i++) {
            series1Data[i] = new XYChart.Data<Number,Number>(i,50);
            series.getData().add(series1Data[i]);
        }
        ac.getData().add(series);
        return ac;
    }

    private void startAudio() {
        if (PLAY_AUDIO) {
            getAudioMediaPlayer().setAudioSpectrumListener(audioSpectrumListener);
            getAudioMediaPlayer().play();
        }
    }

    private void stopAudio() {
        if (getAudioMediaPlayer().getAudioSpectrumListener() == audioSpectrumListener) {
            getAudioMediaPlayer().pause();
        }
    }

   private static MediaPlayer getAudioMediaPlayer() {
        if (audioMediaPlayer == null) {
            Media audioMedia = new Media(AUDIO_URI);
            audioMediaPlayer = new MediaPlayer(audioMedia);
        }
        return audioMediaPlayer;
    }
}
