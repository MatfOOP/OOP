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
package ensemble.samples.scenegraph.events;

import ensemble.Sample;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * A sample that demonstrates changing the cursor icon.
 *
 * @see javafx.scene.Cursor
 */
public class CursorSample extends Sample {

    public CursorSample() {
        TilePane tilePaneRoot = new TilePane(5, 5);
        tilePaneRoot.setHgap(2);
        tilePaneRoot.setVgap(2);
        tilePaneRoot.getChildren().addAll(
            createBox(Cursor.DEFAULT),
            createBox(Cursor.CROSSHAIR),
            createBox(Cursor.TEXT),
            createBox(Cursor.WAIT),
            createBox(Cursor.SW_RESIZE),
            createBox(Cursor.SE_RESIZE),
            createBox(Cursor.NW_RESIZE),
            createBox(Cursor.NE_RESIZE),
            createBox(Cursor.N_RESIZE),
            createBox(Cursor.S_RESIZE),
            createBox(Cursor.W_RESIZE),
            createBox(Cursor.E_RESIZE),
            createBox(Cursor.OPEN_HAND),
            createBox(Cursor.CLOSED_HAND),
            createBox(Cursor.HAND),
            createBox(Cursor.DISAPPEAR),
            createBox(Cursor.MOVE),
            createBox(Cursor.H_RESIZE),
            createBox(Cursor.V_RESIZE),
            createBox(Cursor.NONE)
        );
        getChildren().add(tilePaneRoot);
    }

    private Node createBox(Cursor cursor) {
        Label label = new Label(cursor.toString());
        label.setAlignment(Pos.CENTER);
        label.setPrefSize(85, 85);
        label.setStyle("-fx-border-color: #aaaaaa; -fx-background-color: #dddddd;");
        label.setCursor(cursor);
        return label;
    }
}

