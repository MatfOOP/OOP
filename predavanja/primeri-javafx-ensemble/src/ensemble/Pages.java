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
package ensemble;

import ensemble.pages.AllPagesPage;
import ensemble.pages.CategoryPage;
import ensemble.pages.SamplePage;

/**
 * Pages
 *
 */
public class Pages {
    public static final String SAMPLES = "SAMPLES";
    public static final String API_DOCS = "API DOCUMENTATION";
    public static final String NEW = "NEW!";
    public static final String HIGHLIGHTS = "HIGHLIGHTS";
    private AllPagesPage root;
    private CategoryPage samples;
    private CategoryPage docs;
    private CategoryPage newSamples;
    private CategoryPage highlightedSamples;

    public Pages() {
        // create all the pages
        root = new AllPagesPage();
        samples = new CategoryPage(SAMPLES);
        docs = new CategoryPage(API_DOCS);
        newSamples = new CategoryPage(NEW);
        highlightedSamples = new CategoryPage(HIGHLIGHTS);
        root.getChildren().addAll(highlightedSamples, newSamples);
        root.getChildren().add(samples);
        root.getChildren().add(docs);
    }

    public void parseSamples(){
        SampleHelper.getSamples(samples);
        // ADD PAGES TO HIGHLIGHTS CATEGORY
        highlightedSamples.getChildren().addAll(
                new SamplePage((SamplePage)getPage("SAMPLES/Web/Web View")),
                new SamplePage((SamplePage)getPage("SAMPLES/Web/H T M L Editor")),
                new SamplePage((SamplePage)getPage("SAMPLES/Graphics 3d/Cube")),
                new SamplePage((SamplePage)getPage("SAMPLES/Graphics 3d/Cube System")),
                new SamplePage((SamplePage)getPage("SAMPLES/Graphics 3d/Xylophone")),
                new SamplePage((SamplePage)getPage("SAMPLES/Media/Advanced Media")),
                new SamplePage((SamplePage)getPage("SAMPLES/Graphics/Digital Clock")),
                new SamplePage((SamplePage)getPage("SAMPLES/Graphics/Display Shelf")),
                new SamplePage((SamplePage)getPage("SAMPLES/Charts/Area/Adv Area Audio Chart")),
                new SamplePage((SamplePage)getPage("SAMPLES/Charts/Bar/Adv Bar Audio Chart")),
                new SamplePage((SamplePage)getPage("SAMPLES/Charts/Line/Advanced Stock Line Chart")),
                new SamplePage((SamplePage)getPage("SAMPLES/Charts/Custom/Adv Candle Stick Chart")),
                new SamplePage((SamplePage)getPage("SAMPLES/Charts/Scatter/Advanced Scatter Chart"))
        );
        // ADD PAGES TO NEW CATEGORY
        newSamples.getChildren().addAll(
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Area/Advanced Area Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Area/Adv Area Audio Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Bar/Advanced Bar Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Bar/Adv Bar Audio Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Bar/Adv Horizontal Bar Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Bubble/Advanced Bubble Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Custom/Adv Candle Stick Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Custom/Adv Stacked Bar Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Line/Advanced Line Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Line/Advanced Stock Line Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Line/Adv Line Category Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Pie/Advanced Pie Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Scatter/Advanced Scatter Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Charts/Scatter/Adv Scatter Live Chart")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Accordion")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Buttons/Color Button")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Buttons/Hyperlink")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Buttons/Toggle Button")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Choice Box")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Progress Bar")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Progress Indicator")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Scroll Bar")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Table/Table")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Tabs/Tab")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Text/Text Field")),
            new SamplePage((SamplePage)getPage("SAMPLES/Controls/Tool Bar")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics/Colorful Circles")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics/Digital Clock")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics/Display Shelf")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics/Puzzle Pieces")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics 3d/Cube")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics 3d/Cube System")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics 3d/Xylophone")),
            new SamplePage((SamplePage)getPage("SAMPLES/Graphics 3d/Audio Visualizer")),
            new SamplePage((SamplePage)getPage("SAMPLES/Media/Audio Clip")),
            new SamplePage((SamplePage)getPage("SAMPLES/Scenegraph/Events/Cursor")),
            new SamplePage((SamplePage)getPage("SAMPLES/Scenegraph/Events/Key Stroke Motion")),
            new SamplePage((SamplePage)getPage("SAMPLES/Scenegraph/Node/Custom Node")),
            new SamplePage((SamplePage)getPage("SAMPLES/Scenegraph/Node/Node Properties")),
            new SamplePage((SamplePage)getPage("SAMPLES/Scenegraph/Stage/Advanced Stage")),
            new SamplePage((SamplePage)getPage("SAMPLES/Web/H T M L Editor")),
            new SamplePage((SamplePage)getPage("SAMPLES/Web/Web View"))
        );
    }

    public Page getPage(String name) {
        Page page = root.getChild(name);
//        if (page == null) {
//            System.err.print("Can not load page named '" + name + "'");
//        }
        return page;
    }

    public Page getHighlighted() {
        return highlightedSamples;
    }

    public Page getNew() {
        return newSamples;
    }

    public Page getSamples() {
        return samples;
    }

    public Page getDocs() {
        return docs;
    }

    public Page getRoot() {
        return root;
    }
}
