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
package ensemble.samples.graphics.transforms;

import ensemble.Sample;
import ensemble.controls.SimplePropertySheet;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * An example of how the Translate transform moves a node horizontally and vertically.
 *
 * @related animation/transitions/TranslateTransition
 * @see javafx.scene.transform.Translate
 * @see javafx.scene.transform.Transform
 */
public class TranslateSample extends Sample {

    public TranslateSample() {
        super(230, 220);

        //create 2 rectangles with different color
        Rectangle rect1 = new Rectangle(90, 90, Color.web("#ed4b00", 0.75));
        Rectangle rect2 = new Rectangle(90, 90, Color.web("#ed4b00", 0.5));

        //translate second one
        rect2.setTranslateX(140);

        // rectangle with adjustable translate
        Rectangle rect3 = new Rectangle(40, 130, 60, 60);
        rect3.setFill(Color.DODGERBLUE);
        rect3.setTranslateX(20);
        rect3.setTranslateY(10);

        //show the rectangles
        getChildren().addAll(rect2, rect1, rect3);

        // REMOVE ME
        setControls(
                new SimplePropertySheet.PropDesc("Translate X", rect3.translateXProperty(), 0d, 50d),
                new SimplePropertySheet.PropDesc("Translate Y", rect3.translateYProperty(), 0d, 50d)
        );
        // END REMOVE ME
        
        //create arrow
        Polygon polygon = createArrow();
        polygon.setLayoutX(110);
        polygon.setLayoutY(30);
        polygon.setRotate(90);

        getChildren().addAll(polygon);

    }
    
    public static Polygon createArrow() {
        Polygon polygon = new Polygon(new double[]{
            7.5, 0,
            15, 15,
            10, 15,
            10, 30,
            5, 30,
            5, 15,
            0, 15
        });
        polygon.setFill(Color.web("#ff0900"));
        
        return polygon;
    }

    // REMOVE ME
    public static Node createIconContent() {
        final Rectangle r1 = new Rectangle (0, 0, 20, 20);
        r1.setArcHeight(4);
        r1.setArcWidth(4);
        r1.setFill(Color.web("#ed4b00"));

        Polygon polygon = createArrow();
        polygon.setLayoutX(29);
        polygon.setLayoutY(21);
        polygon.setRotate(135);
        

        Rectangle r2 = new Rectangle (50, 50, 20, 20);
        r2.setArcHeight(4);
        r2.setArcWidth(4);
        r2.setFill(Color.web("#ed4b00"));
        r2.setOpacity(0.5);
        javafx.scene.Group g = new javafx.scene.Group(r2,r1, polygon);
        return new javafx.scene.Group(g);
    }
    // END REMOVE ME
}
