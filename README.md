# Picnic Table Builder for Java & Co.

The Picnic Table Builder library provides a `TableBuilder` API for
Java & Co. to create HTML-like tables that are nice looking when
rendered as Unicode or ASCII. The provided `TableBuilder` is a
Java-shim over [Jake Wharton's great Picnic Tables (picnic)
library](https://github.com/JakeWharton/picnic/). Unfortunately,
picnic itself is not accessible from Scala (apparently due to its
usage of Kotlin's `@set:JvmSynthetic` annotation). Picnic Table
Builder, i.e., this library, solves this issue. It furthermore
provides an IMHO more idiomatic and easier to use builder API than
upstream does.

Originally submitted for upstream inclusion as [Picnic PR
#33](https://github.com/JakeWharton/picnic/pull/33), it is now
released as standalone library.

## Example

```java
Table table = eu.geekplace.picnic.TableBuilder.create()
    .withTableStyle()
        .setBorderStyle(Hidden)
        .endTableStyle()
    .withCellStyle()
        .setAlignment(MiddleRight)
        .setPaddingLeft(1)
        .setPaddingRight(1)
        .setBorderLeft(true)
        .setBorderRight(true)
        .endCellStyle()
    .withHeader()
        .withCellStyle()
            .setBorder(true)
            .setAlignment(BottomLeft)
            .endCellStyle()
        .addRow()
            .addCell("APK")
                .setRowSpan(2)
                .endCell()
            .addCell("compressed")
                .setColumnSpan(3)
                .withCellStyle()
                    .setAlignment(BottomCenter)
                    .endCellStyle()
                .endCell()
            .addCell("uncompressed")
                .setColumnSpan(3)
                .withCellStyle()
                    .setAlignment(BottomCenter)
                    .endCellStyle()
                .endCell()
            .endRow()
        .addRow("old", "new", "diff", "old", "new", "diff")
        .endHeader()
    .withBody()
        .addRow("dex", "664.8 KiB", "664.8 KiB", "-25 B", "1.5 MiB", "1.5 MiB", "-112 B")
        .addRow("arsc", "201.7 KiB", "201.7 KiB", "0 B", "201.6 KiB", "201.6 KiB", "0 B")
        .addRow("manifest", "1.4 KiB", "1.4 KiB", "0 B", "4.2 KiB", "4.2 KiB", "0 B")
        .addRow("res", "418.2 KiB", "418.2 KiB", "-14 B", "488.3 KiB", "488.3 KiB", "0 B")
        .addRow("asset", "0 B", "0 B", "0 B", "0 B", "0 B", "0 B")
        .addRow("other", "37.1 KiB", "37.1 KiB", "0 B", "36.3 KiB", "36.3 KiB", "0 B")
        .endBody()
    .withFooter()
        .withCellStyle()
            .setBorder(true)
            .endCellStyle()
        .addRow("total", "1.3 MiB", "1.3 MiB", "-39 B", "2.2 MiB", "2.2 MiB", "-112 B")
        .endFooter()
    .build();
```

Where `table.toString()` yields:

```
          │          compressed           │          uncompressed
          ├───────────┬───────────┬───────┼───────────┬───────────┬────────
 APK      │ old       │ new       │ diff  │ old       │ new       │ diff
──────────┼───────────┼───────────┼───────┼───────────┼───────────┼────────
      dex │ 664.8 KiB │ 664.8 KiB │ -25 B │   1.5 MiB │   1.5 MiB │ -112 B
     arsc │ 201.7 KiB │ 201.7 KiB │   0 B │ 201.6 KiB │ 201.6 KiB │    0 B
 manifest │   1.4 KiB │   1.4 KiB │   0 B │   4.2 KiB │   4.2 KiB │    0 B
      res │ 418.2 KiB │ 418.2 KiB │ -14 B │ 488.3 KiB │ 488.3 KiB │    0 B
    asset │       0 B │       0 B │   0 B │       0 B │       0 B │    0 B
    other │  37.1 KiB │  37.1 KiB │   0 B │  36.3 KiB │  36.3 KiB │    0 B
──────────┼───────────┼───────────┼───────┼───────────┼───────────┼────────
    total │   1.3 MiB │   1.3 MiB │ -39 B │   2.2 MiB │   2.2 MiB │ -112 B
```

## Maven Coordinates

This library is [available on Maven Central](https://search.maven.org/artifact/eu.geekplace/picnic-table-builder).

### Gradle

```gradle
implementation 'eu.geekplace:picnic-table-builder:<version>'
```

## License

This project is licensed under the Apache License 2.0.
