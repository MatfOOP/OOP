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
package ensemble.samples.animation.timelines;

import ensemble.Sample;
import ensemble.controls.SimplePropertySheet;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * A sample that shows various types of  interpolation  between key frames in a
 * timeline. There are five circles, each animated with a different
 * interpolation method.  The Linear interpolator is the default. Use the
 * controls to reduce opacity to zero for some circles to compare with others,
 * or change circle color to distinguish between individual interpolators.
 *
 * @see javafx.animation.Interpolator
 * @see javafx.animation.KeyFrame
 * @see javafx.animation.KeyValue
 * @see javafx.animation.Timeline
 * @see javafx.util.Duration
 */
public class InterpolatorSample extends Sample {
    private final Timeline timeline = new Timeline();
    public InterpolatorSample() {
        super(200,75);

        //create circles by method createMovingCircle listed below
        Circle circle1 = createMovingCircle(Interpolator.LINEAR); //default interpolator
        circle1.setOpacity(0.7);
        Circle circle2 = createMovingCircle(Interpolator.EASE_BOTH); //circle slows down when reached both ends of trajectory
        circle2.setOpacity(0.45);
        Circle circle3 = createMovingCircle(Interpolator.EASE_IN);
        Circle circle4 = createMovingCircle(Interpolator.EASE_OUT);
        Circle circle5 = createMovingCircle(Interpolator.SPLINE(0.5, 0.1, 0.1, 0.5)); //one can define own behaviour of interpolator by spline method
        
        getChildren().addAll(
                circle1,
                circle2,
                circle3,
                circle4,
                circle5
        );

        // REMOVE ME
        setControls(
                new SimplePropertySheet.PropDesc("LINEAR, Opacity", circle1.opacityProperty(), 0d, 1d),
                new SimplePropertySheet.PropDesc("LINEAR, Color", circle1.fillProperty()),
                new SimplePropertySheet.PropDesc("EASE BOTH, Opacity", circle2.opacityProperty(), 0d, 1d),
                new SimplePropertySheet.PropDesc("EASE BOTH, Color", circle2.fillProperty()),
                new SimplePropertySheet.PropDesc("EASE IN, Opacity", circle3.opacityProperty(), 0d, 1d),
                new SimplePropertySheet.PropDesc("EASE IN, Color", circle3.fillProperty()),
                new SimplePropertySheet.PropDesc("EASE OUT, Opacity", circle4.opacityProperty(), 0d, 1d),
                new SimplePropertySheet.PropDesc("EASE OUT, Color", circle4.fillProperty()),
                new SimplePropertySheet.PropDesc("SPLINE, Opacity", circle5.opacityProperty(), 0d, 1d),
                new SimplePropertySheet.PropDesc("SPLINE, Color", circle5.fillProperty())
        );
        // END REMOVE ME
    }

    private Circle createMovingCircle(Interpolator interpolator) {
        //create a transparent circle
        Circle circle = new Circle(45,45, 40,  Color.web("1c89f4"));
        circle.setOpacity(0);
        //add effect
        circle.setEffect(new Lighting());

        //create a timeline for moving the circle
       
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        //create a keyValue for horizontal translation of circle to the position 155px with given interpolator
        KeyValue keyValue = new KeyValue(circle.translateXProperty(), 155, interpolator);

        //create a keyFrame with duration 4s
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(4), keyValue);

        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);

        return circle;
    }

   @Override public void play() {
        timeline.play();      
    }
 
    @Override public void stop() {
        timeline.stop();
    }

    // REMOVE ME
    public static Node createIconContent() {
        Circle circle1 = new Circle(30, 40, 10, Color.web("#1c89f4", 0.95));
        Circle circle2 = new Circle(74, 40, 10, Color.web("#1c89f4", 0.55));
        
        Circle circle4 = new Circle(30, 74, 10, Color.web("#1c89f4", 0.95));
        Circle circle5 = new Circle(79, 74, 10, Color.web("#1c89f4", 0.55));

        final Timeline tl = new Timeline();
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.setAutoReverse(true);

        tl.getKeyFrames().addAll
            (new KeyFrame(Duration.ZERO,
                          new KeyValue(circle1.translateXProperty(), 0),
                          new KeyValue(circle4.translateXProperty(), 0, Interpolator.EASE_BOTH)),
             new KeyFrame(Duration.seconds(1.3), 
                          new KeyValue(circle1.translateXProperty(), 54),
                          new KeyValue(circle4.translateXProperty(), 54, Interpolator.EASE_BOTH)));
        
        javafx.scene.shape.Rectangle mouseRect = new javafx.scene.shape.Rectangle (0, 0, 114,114);
        mouseRect.setFill(Color.TRANSPARENT);

        javafx.scene.Group g =
                new javafx.scene.Group(mouseRect,
                                       circle1, circle2, circle4, circle5);
        g.setEffect(new Lighting());

        g.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) { tl.play(); }
        });

        g.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) { tl.pause(); }
        });
        return g;
    }
    // END REMOVE ME
}
