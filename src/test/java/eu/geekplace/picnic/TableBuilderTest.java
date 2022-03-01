// SPDX-License-Identifier: Apache-2.0
// Copyright © 2022 Florian Schmaus
package eu.geekplace.picnic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jakewharton.picnic.Table;
import com.jakewharton.picnic.TextAlignment;

public class TableBuilderTest {
    @Test
    public void testRowEnd() {
        Table table = TableBuilder.create()
                .withTableStyle().withBorder().endTableStyle()
            .withCellStyle().paddingLeft(2).paddingRight(5).paddingTop(1).paddingBottom(3).border(true).endCellStyle()
            .withHeader()
            .withCellStyle().alignment(TextAlignment.TopLeft).endCellStyle()
            .addRow().cell("Headline", 3).endRow()
            .endHeader()
            .withBody()
            .withCellStyle().endCellStyle()
            .addRow("Foo", "Bar", "Baz")
            .endBody()
            .build();

        String expected = 
                  "┌────────────────────────────────┐\n"
                + "│                                │\n"
                + "│  Headline                      │\n"
                + "│                                │\n"
                + "│                                │\n"
                + "│                                │\n"
                + "├──────────┬──────────┬──────────┤\n"
                + "│          │          │          │\n"
                + "│  Foo     │  Bar     │  Baz     │\n"
                + "│          │          │          │\n"
                + "│          │          │          │\n"
                + "│          │          │          │\n"
                + "└──────────┴──────────┴──────────┘";

        assertEquals(expected, table.toString());
    }
}
