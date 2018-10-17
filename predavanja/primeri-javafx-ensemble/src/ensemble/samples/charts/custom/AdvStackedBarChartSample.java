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

package ensemble.samples.charts.custom;

import ensemble.Sample;
import ensemble.controls.PropertySheet;
import ensemble.samples.charts.custom.AdvStackedBarChartSample.StackedBarChart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Dimension2D;
import javafx.geometry.Side;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;




/**
 * A stacked bar chart with a variety of controls.
 *
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.NumberAxis
 * @see javafx.scene.chart.ValueAxis
 * @see javafx.scene.chart.XYChart
 */
public class AdvStackedBarChartSample extends Sample {

    public AdvStackedBarChartSample() {
        getChildren().add(createChart());
    }

    protected StackedBarChart<String, Number> createChart() {
        final String[] years = {"2007", "2008", "2009"};
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$",null));
        final StackedBarChart<String,Number> bc = new StackedBarChart<String,Number>(xAxis,yAxis);
        // setup chart
        bc.setTitle("Stacked Bar Chart");
        xAxis.setLabel("Year");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));
        yAxis.setLabel("Price");
        // add starting data
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.setName("Data Series 1");
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.setName("Data Series 2");
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.setName("Data Series 3");
        // create sample data
        series1.getData().add(new XYChart.Data<String,Number>(years[0], 567));
        series1.getData().add(new XYChart.Data<String,Number>(years[1], 1292));
        series1.getData().add(new XYChart.Data<String,Number>(years[2], 2180));
        series2.getData().add(new XYChart.Data<String,Number>(years[0], 956));
        series2.getData().add(new XYChart.Data<String,Number>(years[1], 1665));
        series2.getData().add(new XYChart.Data<String,Number>(years[2], 2450));
        series3.getData().add(new XYChart.Data<String,Number>(years[0], 800));
        series3.getData().add(new XYChart.Data<String,Number>(years[1], 1000));
        series3.getData().add(new XYChart.Data<String,Number>(years[2], 2800));
        bc.getData().add(series1);
        bc.getData().add(series2);
        bc.getData().add(series3);
        return bc;
    }

   // REMOVE ME
    @Override public Node getSideBarExtraContent() {
        return createPropertySheet();
    }

    @Override public String getSideBarExtraContentTitle() {
        return "Chart Properties";
    }

    protected PropertySheet createPropertySheet() {
        final StackedBarChart<String, Number> sbc = (StackedBarChart<String, Number>)getChildren().get(0);
        // create actions
        EventHandler<ActionEvent> changeDataItem = new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                if (!sbc.getData().isEmpty()) {
                    XYChart.Series<String, Number> s = sbc.getData().get((int)(Math.random()*(sbc.getData().size())));
                    if(s!=null && !s.getData().isEmpty()) {
                        XYChart.Data<String, Number> d = s.getData().get((int)(Math.random()*(s.getData().size())));
                        if (d!=null) {
                            d.setYValue(Math.random()*1500d);
                        }
                    }
                }
            }
        };
        EventHandler<ActionEvent> addSeries = new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
                series.setName("Data Series 1");
                CategoryAxis cAxis = ((CategoryAxis)sbc.getXAxis());
                for (String category : cAxis.getCategories()) {
                    series.getData().add(new XYChart.Data<String,Number>(category, Math.random()*3800));
                }
                sbc.getData().add(series);
            }
        };
        EventHandler<ActionEvent> deleteSeries = new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                if (!sbc.getData().isEmpty()) sbc.getData().remove((int)(Math.random()*(sbc.getData().size()-1)));
            }
        };
        // create property sheet
        final CategoryAxis xAxis = (CategoryAxis)sbc.getXAxis();
        final NumberAxis yAxis = (NumberAxis)sbc.getYAxis();
        
       //Create X/Y side overriding values to filter out unhelpful values
        List<Enum> xValidSides = new ArrayList();       
        xValidSides.add(Side.BOTTOM);
        xValidSides.add(Side.TOP);

        List<Enum> yValidSides = new ArrayList();       
        yValidSides.add(Side.LEFT);
        yValidSides.add(Side.RIGHT);
        
        return new PropertySheet(
            new PropertySheet.PropertyGroup("Actions",
                PropertySheet.createProperty("Change Data Item",changeDataItem),
                PropertySheet.createProperty("Add Series",addSeries),
                PropertySheet.createProperty("Delete Series",deleteSeries)
            ),
            new PropertySheet.PropertyGroup("Chart Properties",
                PropertySheet.createProperty("Title",sbc.titleProperty()),
                PropertySheet.createProperty("Title Side",sbc.titleSideProperty()),
                PropertySheet.createProperty("Legend Side",sbc.legendSideProperty())
            ),
            new PropertySheet.PropertyGroup("XY Chart Properties",
                PropertySheet.createProperty("Vertical Grid Line Visible",sbc.verticalGridLinesVisibleProperty()),
                PropertySheet.createProperty("Horizontal Grid Line Visible",sbc.horizontalGridLinesVisibleProperty()),
                PropertySheet.createProperty("Alternative Column Fill Visible",sbc.alternativeColumnFillVisibleProperty()),
                PropertySheet.createProperty("Alternative Row Fill Visible",sbc.alternativeRowFillVisibleProperty()),
                PropertySheet.createProperty("Vertical Zero Line Visible",sbc.verticalZeroLineVisibleProperty()),
                PropertySheet.createProperty("Horizontal Zero Line Visible",sbc.horizontalZeroLineVisibleProperty()),
                PropertySheet.createProperty("Animated",sbc.animatedProperty())
            ),
            new PropertySheet.PropertyGroup("X Axis Properties",
                PropertySheet.createProperty("Side",xAxis.sideProperty(), xValidSides),
                PropertySheet.createProperty("Label",xAxis.labelProperty()),
                PropertySheet.createProperty("Label",xAxis.labelProperty()),
                PropertySheet.createProperty("Tick Mark Length",xAxis.tickLengthProperty()),
                PropertySheet.createProperty("Auto Ranging",xAxis.autoRangingProperty()),
                PropertySheet.createProperty("Tick Label Font",xAxis.tickLabelFontProperty()),
                PropertySheet.createProperty("Tick Label Fill",xAxis.tickLabelFillProperty()),
                PropertySheet.createProperty("Tick Label Gap",xAxis.tickLabelGapProperty()),
                // Value Axis Props
                //PropertySheet.createProperty("Scale",yAxis.scaleProperty(), true),
                PropertySheet.createProperty("Lower Bound",yAxis.lowerBoundProperty(), true),
                PropertySheet.createProperty("Upper Bound",yAxis.upperBoundProperty(), true),
                PropertySheet.createProperty("Tick Label Formatter",yAxis.tickLabelFormatterProperty()),
                PropertySheet.createProperty("Minor Tick Length",yAxis.minorTickLengthProperty()),
                PropertySheet.createProperty("Minor Tick Count",yAxis.minorTickCountProperty()),
                // Number Axis Properties
                PropertySheet.createProperty("Force Zero In Range",yAxis.forceZeroInRangeProperty()),
                PropertySheet.createProperty("Tick Unit",yAxis.tickUnitProperty()),
                // Category Axis Properties
                PropertySheet.createProperty("Start Margin", xAxis.startMarginProperty()),
                PropertySheet.createProperty("End Margin", xAxis.endMarginProperty()),
                PropertySheet.createProperty("Gap Start And End", xAxis.gapStartAndEndProperty())
            ),
            new PropertySheet.PropertyGroup("Y Axis Properties",
                PropertySheet.createProperty("Side",yAxis.sideProperty(), yValidSides),
                PropertySheet.createProperty("Label",yAxis.labelProperty()),
                PropertySheet.createProperty("Label",yAxis.labelProperty()),
                PropertySheet.createProperty("Tick Mark Length",yAxis.tickLengthProperty()),
                PropertySheet.createProperty("Auto Ranging",yAxis.autoRangingProperty()),
                PropertySheet.createProperty("Tick Label Font",yAxis.tickLabelFontProperty()),
                PropertySheet.createProperty("Tick Label Fill",yAxis.tickLabelFillProperty()),
                PropertySheet.createProperty("Tick Label Gap",yAxis.tickLabelGapProperty()),
                // Value Axis Props
                //PropertySheet.createProperty("Scale",yAxis.scaleProperty(), true),
                PropertySheet.createProperty("Lower Bound",yAxis.lowerBoundProperty(), true),
                PropertySheet.createProperty("Upper Bound",yAxis.upperBoundProperty(), true),
                PropertySheet.createProperty("Tick Label Formatter",yAxis.tickLabelFormatterProperty()),
                PropertySheet.createProperty("Minor Tick Length",yAxis.minorTickLengthProperty()),
                PropertySheet.createProperty("Minor Tick Count",yAxis.minorTickCountProperty()),
                // Number Axis Properties
                PropertySheet.createProperty("Force Zero In Range",yAxis.forceZeroInRangeProperty()),
                PropertySheet.createProperty("Tick Unit",yAxis.tickUnitProperty())
            )
        );
    }
// END REMOVE ME

    /**
     * A chart that plots bars indicating data values for a category. The bars can be vertical or horizontal depending on
     * which axis is a category axis. The bar for each series is stacked on top of the previous series.
     */
    public class StackedBarChart<X, Y> extends XYChart<X, Y> {
        // -------------- PRIVATE FIELDS -------------------------------------------
        private Map<Series, Map<String, Data<X, Y>>> seriesCategoryMap = new HashMap<Series, Map<String, Data<X, Y>>>();
        private Legend legend = new Legend();
        private final Orientation orientation;
        private CategoryAxis categoryAxis;
        private ValueAxis valueAxis;
        private int seriesDefaultColorIndex = 0;
        private Map<Series<X, Y>, String> seriesDefaultColorMap = new HashMap<Series<X, Y>, String>();
        // -------------- PUBLIC PROPERTIES ----------------------------------------
        /** The gap to leave between bars in separate categories */
        private DoubleProperty categoryGap = new SimpleDoubleProperty(10) {
            @Override protected void invalidated() {
                get();
                requestChartLayout();
            }
        };

        public double getCategoryGap() {
            return categoryGap.getValue();
        }

        public void setCategoryGap(double value) {
            categoryGap.setValue(value);
        }

        public DoubleProperty categoryGapProperty() {
            return categoryGap;
        }

        // -------------- CONSTRUCTOR ----------------------------------------------
        /**
         * Construct a new BarChart with the given axis. The two axis should be a ValueAxis/NumberAxis and a CategoryAxis,
         * they can be in either order depending on if you want a horizontal or vertical bar chart.
         *
         * @param xAxis The x axis to use
         * @param yAxis The y axis to use
         */
        public StackedBarChart(Axis<X> xAxis, Axis<Y> yAxis) {
            this(xAxis, yAxis, FXCollections.<Series<X, Y>>observableArrayList());
        }

        /**
         * Construct a new BarChart with the given axis and data. The two axis should be a ValueAxis/NumberAxis and a
         * CategoryAxis, they can be in either order depending on if you want a horizontal or vertical bar chart.
         *
         * @param xAxis The x axis to use
         * @param yAxis The y axis to use
         * @param data The data to use, this is the actual list used so any changes to it will be reflected in the chart
         */
        public StackedBarChart(Axis<X> xAxis, Axis<Y> yAxis, ObservableList<Series<X, Y>> data) {
            super(xAxis, yAxis);
            getStyleClass().add("stacked-bar-chart");
            setLegend(legend);
            if (!((xAxis instanceof ValueAxis && yAxis instanceof CategoryAxis)
                    || (yAxis instanceof ValueAxis && xAxis instanceof CategoryAxis))) {
                throw new IllegalArgumentException("Axis type incorrect, one of X,Y should be CategoryAxis and the other NumberAxis");
            }
            if (xAxis instanceof CategoryAxis) {
                categoryAxis = (CategoryAxis) xAxis;
                valueAxis = (ValueAxis) yAxis;
                orientation = Orientation.VERTICAL;
            } else {
                categoryAxis = (CategoryAxis) yAxis;
                valueAxis = (ValueAxis) xAxis;
                orientation = Orientation.HORIZONTAL;
            }
            setData(data);
        }

        /**
         * Construct a new BarChart with the given axis and data. The two axis should be a ValueAxis/NumberAxis and a
         * CategoryAxis, they can be in either order depending on if you want a horizontal or vertical bar chart.
         *
         * @param xAxis The x axis to use
         * @param yAxis The y axis to use
         * @param data The data to use, this is the actual list used so any changes to it will be reflected in the chart
         * @param categoryGap The gap to leave between bars in separate categories
         */
        public StackedBarChart(Axis<X> xAxis, Axis<Y> yAxis, ObservableList<Series<X, Y>> data, double categoryGap) {
            this(xAxis, yAxis);
            setData(data);
            setCategoryGap(categoryGap);
        }

        // -------------- METHODS --------------------------------------------------
        @Override protected void dataItemAdded(Series<X, Y> series, int itemIndex, Data<X, Y> item) {
            String category;
            if (orientation == Orientation.VERTICAL) {
                category = (String) item.getXValue();
            } else {
                category = (String) item.getYValue();
            }
            // Don't plot if category does not already exist ?
//        if (!categoryAxis.getCategories().contains(category)) return;

            Map<String, Data<X, Y>> categoryMap = seriesCategoryMap.get(series);

            if (categoryMap == null) {
                categoryMap = new HashMap<String, Data<X, Y>>();
                seriesCategoryMap.put(series, categoryMap);
            }
            categoryMap.put(category, item);
            Node bar = createBar(series, getData().indexOf(series), item, itemIndex);
            if (shouldAnimate()) {
                animateDataAdd(item, bar);
            } else {
                getPlotChildren().add(bar);
            }
        }

        @Override protected void dataItemRemoved(final Data<X, Y> item, final Series<X, Y> series) {
            final Node bar = item.getNode();
            if (shouldAnimate()) {
                Timeline t = createDataRemoveTimeline(item, bar, series);
                t.setOnFinished(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        removeDataItemFromDisplay(series, item);
                    }
                });
                t.play();
            } else {
                getPlotChildren().remove(bar);
                removeDataItemFromDisplay(series, item);
            }
        }

        /** @inheritDoc */
        @Override protected void dataItemChanged(Data<X, Y> item) {
            double barVal;
            double currentVal;
            if (orientation == Orientation.VERTICAL) {
                barVal = ((Number) item.getYValue()).doubleValue();
                currentVal = ((Number) getCurrentDisplayedYValue(item)).doubleValue();
            } else {
                barVal = ((Number) item.getXValue()).doubleValue();
                currentVal = ((Number) getCurrentDisplayedXValue(item)).doubleValue();
            }
            if (currentVal > 0 && barVal < 0) { // going from positive to negative
                // add style class negative
                item.getNode().getStyleClass().add("negative");
            } else if (currentVal < 0 && barVal > 0) { // going from negative to positive
                // remove style class negative
                item.getNode().getStyleClass().add("negative");
            }
        }

        private void animateDataAdd(Data<X, Y> item, Node bar) {
            double barVal;
            if (orientation == Orientation.VERTICAL) {
                barVal = ((Number) item.getYValue()).doubleValue();
                if (barVal < 0) {
                    bar.getStyleClass().add("negative");
                }
                item.setYValue(getYAxis().toRealValue(getYAxis().getZeroPosition()));
                setCurrentDisplayedYValue(item, getYAxis().toRealValue(getYAxis().getZeroPosition()));
                getPlotChildren().add(bar);
                item.setYValue(getYAxis().toRealValue(barVal));
                animate(
                        TimelineBuilder.create().keyFrames(
                        new KeyFrame(Duration.ZERO, new KeyValue(currentDisplayedYValueProperty(item), getCurrentDisplayedYValue(item))),
                        new KeyFrame(Duration.millis(700), new KeyValue(currentDisplayedYValueProperty(item), item.getYValue(), Interpolator.EASE_BOTH))).build());
            } else {
                barVal = ((Number) item.getXValue()).doubleValue();
                if (barVal < 0) {
                    bar.getStyleClass().add("negative");
                }
                item.setXValue(getXAxis().toRealValue(getXAxis().getZeroPosition()));
                setCurrentDisplayedXValue(item, getXAxis().toRealValue(getXAxis().getZeroPosition()));
                getPlotChildren().add(bar);
                item.setXValue(getXAxis().toRealValue(barVal));
                animate(
                        TimelineBuilder.create().keyFrames(
                        new KeyFrame(Duration.ZERO, new KeyValue(currentDisplayedXValueProperty(item), getCurrentDisplayedXValue(item))),
                        new KeyFrame(Duration.millis(700), new KeyValue(currentDisplayedXValueProperty(item), item.getXValue(), Interpolator.EASE_BOTH))).build());
            }
        }

        @Override protected void seriesAdded(Series<X, Y> series, int seriesIndex) {
            String defaultColorStyleClass = "default-color" + (seriesDefaultColorIndex % 8);
            seriesDefaultColorMap.put(series, defaultColorStyleClass);
            seriesDefaultColorIndex++;
            // handle any data already in series
            // create entry in the map
            Map<String, Data<X, Y>> categoryMap = new HashMap<String, Data<X, Y>>();
            for (int j = 0; j < series.getData().size(); j++) {
                Data<X, Y> item = series.getData().get(j);
                Node bar = createBar(series, seriesIndex, item, j);
                String category;
                if (orientation == Orientation.VERTICAL) {
                    category = (String) item.getXValue();
                } else {
                    category = (String) item.getYValue();
                }
                categoryMap.put(category, item);
                if (shouldAnimate()) {
                    animateDataAdd(item, bar);
                } else {
                    getPlotChildren().add(bar);
                }
            }
            if (categoryMap.size() > 0) {
                seriesCategoryMap.put(series, categoryMap);
            }
        }

        private Timeline createDataRemoveTimeline(Data<X, Y> item, final Node bar, final Series<X, Y> series) {
            Timeline t = new Timeline();
            if (orientation == Orientation.VERTICAL) {
                item.setYValue(getYAxis().toRealValue(getYAxis().getZeroPosition()));
                t.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, new KeyValue(currentDisplayedYValueProperty(item), getCurrentDisplayedYValue(item))),
                        new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        getPlotChildren().remove(bar);
                    }
                },
                        new KeyValue(currentDisplayedYValueProperty(item), item.getYValue(), Interpolator.EASE_BOTH)));
            } else {
                item.setXValue(getXAxis().toRealValue(getXAxis().getZeroPosition()));
                t.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, new KeyValue(currentDisplayedXValueProperty(item), getCurrentDisplayedXValue(item))),
                        new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        getPlotChildren().remove(bar);
                    }
                },
                        new KeyValue(currentDisplayedXValueProperty(item), item.getXValue(), Interpolator.EASE_BOTH)));
            }
            return t;
        }

        @Override protected void seriesRemoved(final Series<X, Y> series) {
            // remove all symbol nodes
            if (shouldAnimate()) {
                ParallelTransition pt = new ParallelTransition();
                pt.setOnFinished(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        removeSeriesFromDisplay(series);
                    }
                });
                for (Data<X, Y> d : series.getData()) {
                    final Node bar = d.getNode();
                    // Animate series deletion
                    if (getSeriesSize() > 1) {
                        for (int j = 0; j < series.getData().size(); j++) {
                            Data<X, Y> item = series.getData().get(j);
                            Timeline t = createDataRemoveTimeline(item, bar, series);
                            pt.getChildren().add(t);
                        }
                    } else {
                        // fade out last series
                        FadeTransition ft = new FadeTransition(Duration.millis(700), bar);
                        ft.setFromValue(1);
                        ft.setToValue(0);
                        ft.setOnFinished(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent actionEvent) {
                                getPlotChildren().remove(bar);
                            }
                        });
                        pt.getChildren().add(ft);
                    }
                }
                pt.play();
            } else {
                for (Data<X, Y> d : series.getData()) {
                    final Node bar = d.getNode();
                    getPlotChildren().remove(bar);
                }
                removeSeriesFromDisplay(series);
            }
        }

        /**
         * This is called when the range has been invalidated and we need to update it. If the axis are auto
         * ranging then we compile a list of all data that the given axis has to plot and call invalidateRange() on the
         * axis passing it that data.
         */
        @Override protected void updateAxisRange() {
            // For candle stick chart we need to override this method as we need to let the axis know that they need to be able
            // to cover the whole area occupied by the high to low range not just its center data value
            final Axis<X> xa = getXAxis();
            final Axis<Y> ya = getYAxis();
            if (xa.isAutoRanging()) {
                List xData = new ArrayList<Number>();
                if (xa instanceof CategoryAxis) {
                    xData.addAll(categoryAxis.getCategories());
                } else {
                    int catIndex = 0;
                    for (String category : categoryAxis.getCategories()) {
                        int index = 0;
                        double totalX = 0;
                        Iterator<Series<X, Y>> seriesIterator = getDisplayedSeriesIterator();
                        while (seriesIterator.hasNext()) {
                            Series<X, Y> series = seriesIterator.next();
                            final Data<X, Y> item = getDataItem(series, index, catIndex, category);
                            totalX += xa.toNumericValue(item.getXValue());
                        }
                        xData.add(totalX);
                        catIndex++;
                    }
                }
                xa.invalidateRange(xData);
            }
            if (ya.isAutoRanging()) {
                List yData = new ArrayList<Number>();
                if (ya instanceof CategoryAxis) {
                    yData.addAll(categoryAxis.getCategories());
                } else {
                    int catIndex = 0;
                    for (String category : categoryAxis.getCategories()) {
                        int index = 0;
                        double totalY = 0;
                        Iterator<Series<X, Y>> seriesIterator = getDisplayedSeriesIterator();
                        while (seriesIterator.hasNext()) {
                            Series<X, Y> series = seriesIterator.next();
                            final Data<X, Y> item = getDataItem(series, index, catIndex, category);
                            totalY += ya.toNumericValue(item.getYValue());
                        }
                        yData.add(totalY);
                        catIndex++;
                    }
                }
                ya.invalidateRange(yData);
            }
        }

        /** @inheritDoc */
        @Override protected void layoutPlotChildren() {
            double catSpace = categoryAxis.getCategorySpacing();
            // calculate bar spacing
            final double availableBarSpace = catSpace - getCategoryGap();
            final double barWidth = availableBarSpace;
            final double barOffset = -((catSpace - getCategoryGap()) / 2);
            final double zeroPos = valueAxis.getZeroPosition();
            checkForNullCategory();
            // update bar positions and sizes
            int catIndex = 0;
            for (String category : categoryAxis.getCategories()) {
                int index = 0;
                int currentHeight = 0;
                Iterator<Series<X, Y>> seriesIterator = getDisplayedSeriesIterator();
                while (seriesIterator.hasNext()) {
                    Series<X, Y> series = seriesIterator.next();
                    final Data<X, Y> item = getDataItem(series, index, catIndex, category);
                    if (item != null) {
                        final Node bar = item.getNode();
                        final double categoryPos;
                        final double valPos;
                        if (orientation == Orientation.VERTICAL) {
                            categoryPos = getXAxis().getDisplayPosition(getCurrentDisplayedXValue(item));
                            valPos = getYAxis().getDisplayPosition(getCurrentDisplayedYValue(item));
                        } else {
                            categoryPos = getYAxis().getDisplayPosition(getCurrentDisplayedYValue(item));
                            valPos = getXAxis().getDisplayPosition(getCurrentDisplayedXValue(item));
                        }
                        final double bottom = currentHeight + Math.min(valPos, zeroPos);
                        final double top = currentHeight + Math.max(valPos, zeroPos);
                        if (orientation == Orientation.VERTICAL) {
                            bar.resizeRelocate(categoryPos + barOffset,
                                    bottom, barWidth, top - bottom);
                        } else {
                            //noinspection SuspiciousNameCombination
                            bar.resizeRelocate(bottom,
                                    categoryPos + barOffset,
                                    top - bottom, barWidth);
                        }
                        currentHeight -= top - bottom;
                        index++;
                    }
                }
                catIndex++;
            }
        }

        /**
         * Computes the size of series linked list
         * @return size of series linked list
         */
        private int getSeriesSize() {
            int count = 0;
            Iterator<Series<X, Y>> seriesIterator = getDisplayedSeriesIterator();
            while (seriesIterator.hasNext()) {
                seriesIterator.next();
                count++;
            }
            return count;
        }

        /**
         * This is called whenever a series is added or removed and the legend needs to be updated
         */
        @Override protected void updateLegend() {
            legend.getItems().clear();
            if (getData() != null) {
                for (int seriesIndex = 0; seriesIndex < getData().size(); seriesIndex++) {
                    Series series = getData().get(seriesIndex);
                    LegendItem legenditem = new LegendItem(series.getName());
                    String defaultColorStyleClass = seriesDefaultColorMap.get(series);
                    legenditem.getSymbol().getStyleClass().addAll("chart-bar", "series" + seriesIndex, "bar-legend-symbol",
                            defaultColorStyleClass);
                    legend.getItems().add(legenditem);
                }
            }
        }

        private Node createBar(Series series, int seriesIndex, final Data item, int itemIndex) {
            Node bar = item.getNode();
            if (bar == null) {
                bar = new StackPane();
                item.setNode(bar);
            }
            String defaultColorStyleClass = seriesDefaultColorMap.get(series);
            bar.getStyleClass().setAll("chart-bar", "series" + seriesIndex, "data" + itemIndex, defaultColorStyleClass);
            return bar;
        }

        private Data<X, Y> getDataItem(Series<X, Y> series, int seriesIndex, int itemIndex, String category) {
            // TODO : do we need NullCategory?
            if (nullCategory.size() > 0 && nullCategory.get(seriesIndex)) {
                return series.getData().get(itemIndex);
            }
            Map<String, Data<X, Y>> catmap = seriesCategoryMap.get(series);
            return catmap.get(category);
        }
        private List<Boolean> nullCategory = new ArrayList<Boolean>();

        private void checkForNullCategory() {
            Iterator<Series<X, Y>> seriesIterator = getDisplayedSeriesIterator();
            while (seriesIterator.hasNext()) {
                Series<X, Y> series = seriesIterator.next();
                boolean n = true;
                int size = (orientation == Orientation.VERTICAL)
                        ? ((CategoryAxis) getXAxis()).getCategories().size()
                        : ((CategoryAxis) getYAxis()).getCategories().size();
                if (series.getData().size() == size) {
                    for (Data<X, Y> item : series.getData()) {
                        if (orientation == Orientation.VERTICAL) {
                            if (item.getXValue() != null) {
                                n = false;
                                break;
                            }
                        } else {
                            if (item.getYValue() != null) {
                                n = false;
                                break;
                            }
                        }
                    }
                }
                nullCategory.add(n);
            }
        }
    }

    /**
     * A chart legend that displays a list of items with symbols in a box
     */
    private class Legend extends Region {

        private static final int GAP = 5;
        // -------------- PRIVATE FIELDS ------------------------------------------
        private int rows = 0, columns = 0;
        private ListChangeListener<LegendItem> itemsListener = new ListChangeListener<LegendItem>() {

            @Override
            public void onChanged(Change<? extends LegendItem> c) {
                getChildren().clear();
                for (LegendItem item : getItems()) {
                    getChildren().add(item.label);
                }
                if (isVisible()) {
                    requestLayout();
                }
            }
        };
        // -------------- PUBLIC PROPERTIES ----------------------------------------
        /**
         * The legend items should be laid out vertically in columns rather than
         * horizontally in rows
         */
        private BooleanProperty vertical = new BooleanPropertyBase(false) {

            @Override
            protected void invalidated() {
                requestLayout();
            }

            @Override
            public Object getBean() {
                return Legend.this;
            }

            @Override
            public String getName() {
                return "vertical";
            }
        };

        public final boolean isVertical() {
            return vertical.get();
        }

        public final void setVertical(boolean value) {
            vertical.set(value);
        }

        public final BooleanProperty verticalProperty() {
            return vertical;
        }
        /**
         * The legend items to display in this legend
         */
        private ObjectProperty<ObservableList<LegendItem>> items = new ObjectPropertyBase<ObservableList<LegendItem>>() {

            ObservableList<LegendItem> oldItems = null;

            @Override
            protected void invalidated() {
                if (oldItems != null) {
                    oldItems.removeListener(itemsListener);
                }
                getChildren().clear();
                ObservableList<LegendItem> newItems = get();
                if (newItems != null) {
                    newItems.addListener(itemsListener);
                    for (LegendItem item : newItems) {
                        getChildren().add(item.label);
                    }
                }
                oldItems = get();
                requestLayout();
            }

            @Override
            public Object getBean() {
                return Legend.this;
            }

            @Override
            public String getName() {
                return "items";
            }
        };

        public final void setItems(ObservableList<LegendItem> value) {
            itemsProperty().set(value);
        }

        public final ObservableList<LegendItem> getItems() {
            return items.get();
        }

        public final ObjectProperty<ObservableList<LegendItem>> itemsProperty() {
            return items;
        }

        // -------------- PROTECTED PROPERTIES ------------------------------------
        // -------------- CONSTRUCTORS ----------------------------------------------
        public Legend() {
            setItems(FXCollections.<LegendItem>observableArrayList());
            getStyleClass().setAll("chart-legend");
        }

        // -------------- METHODS ---------------------------------------------------
        private Dimension2D getTileSize() {
            double maxWidth = 0;
            double maxHeight = 0;
            for (LegendItem item : getItems()) {
                maxWidth = Math.max(maxWidth, item.label.prefWidth(-1));
                maxHeight = Math.max(maxHeight, item.label.prefHeight(-1));
            }
            return new Dimension2D(Math.ceil(maxWidth), Math.ceil(maxHeight));
        }

        @Override
        protected double computePrefWidth(double height) {
            final double contentHeight = height - getInsets().getTop() - getInsets().getBottom();
            Dimension2D tileSize = getTileSize();
            if (height == -1) {
                if (columns <= 1) {
                    return tileSize.getWidth() + getInsets().getLeft() + getInsets().getRight();
                }
            } else {
                rows = (int) Math.floor(contentHeight / (tileSize.getHeight() + GAP));
                columns = (int) Math.ceil(getItems().size() / (double) rows);
            }
            if (columns == 1) {
                rows = Math.min(rows, getItems().size());
            }
            return (columns * (tileSize.getWidth() + GAP)) - GAP + getInsets().getLeft() + getInsets().getRight();
        }

        @Override
        protected double computePrefHeight(double width) {
            final double contentWidth = width - getInsets().getLeft() - getInsets().getRight();
            Dimension2D tileSize = getTileSize();
            if (width == -1) {
                if (rows <= 1) {
                    return tileSize.getHeight() + getInsets().getTop() + getInsets().getBottom();
                }
            } else {
                columns = (int) Math.floor(contentWidth / (tileSize.getWidth() + GAP));
                rows = (int) Math.ceil(getItems().size() / (double) columns);
            }
            if (rows == 1) {
                columns = Math.min(columns, getItems().size());
            }
            return (rows * (tileSize.getHeight() + GAP)) - GAP + getInsets().getTop() + getInsets().getBottom();
        }

        @Override
        protected void layoutChildren() {
            Dimension2D tileSize = getTileSize();
            if (isVertical()) {
                double left = getInsets().getLeft();
                outer:
                for (int col = 0; col < columns; col++) {
                    double top = getInsets().getTop();
                    for (int row = 0; row < rows; row++) {
                        int itemIndex = (col * rows) + row;
                        if (itemIndex >= getItems().size()) {
                            break outer;
                        }
                        getItems().get(itemIndex).label.resizeRelocate(left, top, tileSize.getWidth(), tileSize.getHeight());
                        top += tileSize.getHeight() + GAP;
                    }
                    left += tileSize.getWidth() + GAP;
                }
            } else {
                double top = getInsets().getTop();
                outer:
                for (int row = 0; row < rows; row++) {
                    double left = getInsets().getLeft();
                    for (int col = 0; col < columns; col++) {
                        int itemIndex = (row * columns) + col;
                        if (itemIndex >= getItems().size()) {
                            break outer;
                        }
                        getItems().get(itemIndex).label.resizeRelocate(left, top, tileSize.getWidth(), tileSize.getHeight());
                        left += tileSize.getWidth() + GAP;
                    }
                    top += tileSize.getHeight() + GAP;
                }
            }
        }
    }
    /** A item to be displayed on a Legend */
    private class LegendItem {
        /**
         * Label used to represent the legend item
         */
        private Label label = new Label();
        /**
         * The item text
         */
        private StringProperty text = new StringPropertyBase() {
            @Override
            protected void invalidated() {
                label.setText(get());
            }
            @Override
            public Object getBean() {
                return LegendItem.this;
            }
            @Override
            public String getName() {
                return "text";
            }
        };

        public final String getText() {
            return text.getValue();
        }

        public final void setText(String value) {
            text.setValue(value);
        }

        public final StringProperty textProperty() {
            return text;
        }
        /**
         * The symbol to use next to the item text, set to null for no symbol.
         * The default is a simple square of symbolFill
         */
        //new Rectangle(8,8,null)
        private ObjectProperty<Node> symbol = new ObjectPropertyBase<Node>(new Region()) {

            @Override
            protected void invalidated() {
                Node symbol = get();
                if (symbol != null) {
                    symbol.getStyleClass().setAll("chart-legend-item-symbol");
                }
                label.setGraphic(symbol);
            }

            @Override
            public Object getBean() {
                return LegendItem.this;
            }

            @Override
            public String getName() {
                return "symbol";
            }
        };

        public final Node getSymbol() {
            return symbol.getValue();
        }

        public final void setSymbol(Node value) {
            symbol.setValue(value);
        }

        public final ObjectProperty<Node> symbolProperty() {
            return symbol;
        }

        public LegendItem(String text) {
            setText(text);
            label.getStyleClass().add("chart-legend-item");
            label.setAlignment(Pos.CENTER_LEFT);
            label.setContentDisplay(ContentDisplay.LEFT);
            label.setGraphic(getSymbol());
            getSymbol().getStyleClass().setAll("chart-legend-item-symbol");
        }

        public LegendItem(String text, Node symbol) {
            this(text);
            setSymbol(symbol);
        }
    }    
}
