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
package ensemble.samples.language.beans;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import ensemble.Sample;

/**
 * A sample that demonstrates how to add or remove a change listener on a node
 * (for example, a Rectangle node) for some property (for example,
 * Rectangle.hover). Once you add a listener, the text field  shows the hover
 * property change.
 *
 * @see javafx.beans.value.ChangeListener
 * @see javafx.beans.InvalidationListener
 * @see javafx.beans.value.ObservableValue
 */
public class ChangeListenerSample extends Sample {

    public ChangeListenerSample() {
        super(400, 80);
        HBox outerHbox = new HBox();
        VBox vbox = new VBox(10);
        vbox.setPrefWidth(200);
        // create rectangle
        final Rectangle rect = new Rectangle(150,0,60,60);
        rect.setFill(Color.DODGERBLUE);
        rect.setEffect(new Lighting());
        //create text field for showing actual message
        final Text text = new Text(0,0, "Add a hover listener");
        text.setStyle("-fx-font-size: 22;");
        text.setTextOrigin(VPos.TOP);
        text.setTextAlignment(TextAlignment.CENTER);
        // create listener
        final InvalidationListener hoverListener = new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (rect.isHover()) {
                    text.setText("hovered");
                } else {
                    text.setText("not hovered");
                }
            }
        };
        //create button for adding listener
        Button buttonAdd = new Button("Add listener");
        buttonAdd.setPrefSize(140, 18);
        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //add the listener on property hover
                rect.hoverProperty().addListener(hoverListener);
                text.setText("listener added");
            }
        });
        //create a button for removing the listener
        Button buttonRemove = new Button("Remove listener");
        buttonRemove.setPrefSize(140, 18);
        buttonRemove.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                //remove the listener
                rect.hoverProperty().removeListener(hoverListener);
                text.setText("listener removed");
            }
        });
        // show all nodes
        vbox.getChildren().addAll(text, buttonAdd, buttonRemove);
        outerHbox.getChildren().addAll(vbox, rect);
        getChildren().add(outerHbox);
    }

    // REMOVE ME
    private static Group createBean(double rotate, double translateX, double translateY) {
        javafx.scene.shape.Ellipse bean1 = new javafx.scene.shape.Ellipse(16, 10);
        javafx.scene.shape.Ellipse bean1end = new javafx.scene.shape.Ellipse( 4,3, 3.2, 1.8);
        bean1end.setFill(Color.WHITESMOKE);
        bean1.setFill(Color.BROWN);
        javafx.scene.Group group = new javafx.scene.Group(bean1, bean1end);
        group.setRotate(rotate);
        group.setTranslateX(translateX+57);
        group.setTranslateY(translateY+57);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(3);
        group.setEffect(dropShadow);
        return group;
    }

    public static Node createIconContent() {
       Group bean1 = createBean(-15, 0, 0);
       Group bean2 = createBean(30, -20, -16);
       Group bean3 = createBean(100, 20, 22);
       Group bean4 = createBean(75, -10, 18);
        final Timeline tl = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1.5),
                new KeyValue(bean1.rotateProperty(), java.lang.Math.random()*360),
                new KeyValue(bean2.rotateProperty(), java.lang.Math.random()*360),
                new KeyValue(bean3.rotateProperty(), java.lang.Math.random()*360),
                new KeyValue(bean4.rotateProperty(), java.lang.Math.random()*360));
        tl.getKeyFrames().add(keyFrame);
        javafx.scene.shape.Rectangle mouseRect = new javafx.scene.shape.Rectangle (0, 0, 114,114);
        mouseRect.setFill(Color.TRANSPARENT);
        mouseRect.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                tl.playFromStart();
            }
        });
        mouseRect.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                tl.pause();
            }
        });
       return new javafx.scene.Group(bean1, bean2, bean3, bean4, mouseRect);
    }
    // END REMOVE ME
}
