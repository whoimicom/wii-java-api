package com.whoimi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Stream;

/**
 * @author whoimi
 * @since 2021-10-28
 */
@SuppressWarnings("unused")
public class ShortcutUtils {
    private static final Logger log = LoggerFactory.getLogger(ShortcutUtils.class);
    public static final String SOURCE_PATH = "D:\\home\\notes\\lang\\javascript\\react.md";
    public static final String TARGET_PATH = "D:\\shortcut\\shortcut_.txt";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        formatMarkdown();
    }

    /**
     * | Format Specifier | Data Type | Output |
     * | ---              | ---       | ---    |
     *
     * @throws IOException exception
     */
    public static void formatMarkdown() throws IOException {
        AtomicInteger countLine;
        Map<Integer, Map<Integer, String>> columnData;
        Map<Integer, Integer> maxLength;
        AtomicInteger columnCount;
        Path targetPath = Paths.get(TARGET_PATH);
        Files.deleteIfExists(targetPath);
        Files.createDirectories(targetPath.getParent());
        Files.createFile(targetPath);
        try (Stream<String> lines = Files.lines(Paths.get(SOURCE_PATH))) {
            countLine = new AtomicInteger(1);
            columnData = new HashMap<>(1);
            maxLength = new HashMap<>(1);
            columnCount = new AtomicInteger(0);
            lines.forEach(lin -> {
                AtomicReferenceArray<String> split = new AtomicReferenceArray<>(lin.split("\\|"));
                int length = split.length();
                if (countLine.get() == 1) {
                    columnCount.set(length);
                    for (int column = 1; column < columnCount.get(); column++) {
                        String value = split.get(column);
                        AtomicReference<Map<Integer, String>> columnMap = new AtomicReference<>(new HashMap<>());
                        columnMap.get().put(1, value);
                        columnData.put(column, columnMap.get());
                    }
                } else if (countLine.get() == 2) {
                    for (int column = 1; column < columnCount.get(); column++) {
                        Map<Integer, String> columnMap = columnData.get(column);
                        columnMap.put(countLine.get(), "-");
                    }
                } else {
                    for (int column = 1; column < columnCount.get(); column++) {
                        String value = split.get(column);
                        Map<Integer, String> columnMap = columnData.get(column);
                        columnMap.put(countLine.get(), value);
                    }
                }
                countLine.getAndIncrement();
            });
        }
        for (int column = 1; column < columnCount.get(); column++) {
            Map<Integer, String> columnMap = columnData.get(column);
            Integer max = columnMap.values().stream().map(String::length).max(Integer::compareTo).orElse(0);
            maxLength.put(column, max);
        }
        for (int line = 1; line < countLine.get(); line++) {
            StringBuilder allLine = new StringBuilder("|");
            for (int column = 1; column < columnCount.get(); column++) {
                Map<Integer, String> integerStringMap = columnData.get(column);
                String s = integerStringMap.get(line);
                if (line == 2) {
                    allLine.append(String.format("%1$-" + maxLength.get(column) + "s", s).replace(" ", "-")).append(" |");
                } else {
                    allLine.append(String.format("%1$-" + maxLength.get(column) + "s", s)).append(" |");
                }

            }
            allLine.append("\r\n");
            System.out.print(allLine);
            Files.writeString(targetPath, allLine, StandardOpenOption.APPEND);
        }
//        System.out.println(columnData);
        System.out.println("FINISH");
    }

    public static void formatShortcut() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(SOURCE_PATH))) {
            Path path = Paths.get(TARGET_PATH);
            Files.deleteIfExists(path);
            Files.createFile(path);
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                lines.forEach(lin -> {
                    AtomicReferenceArray<String> split = new AtomicReferenceArray<>(lin.split("\\|➤"));
                    if ((split.length() >= 2)) {
                        try {
                            String str = String.format("%1$-" + 27 + "s", split.get(0).trim()) + " |➤" + split.get(1).trim() + LINE_SEPARATOR;
                            System.out.print(str);
                            bufferedWriter.write(str);
                        } catch (IOException e) {
                            log.error(e.getMessage(),e);
                        }
                    } else {
                        try {
                            bufferedWriter.write(lin + LINE_SEPARATOR);
                        } catch (IOException e) {
                            log.error(e.getMessage(),e);
                        }
                    }

                });
            }
        }
        System.out.println("FINISH");
    }

    @SuppressWarnings("WriteOnlyObject")
    public static void formatShortcutHaveBreak() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(SOURCE_PATH))) {
            String lineSeparator = System.lineSeparator();
            AtomicReference<String> key = new AtomicReference<>("");
            AtomicReference<String> val = new AtomicReference<>("");
            AtomicBoolean isKey = new AtomicBoolean(false);
            Path path = Paths.get(TARGET_PATH);
            Files.deleteIfExists(path);
            Files.createFile(path);
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                lines.forEach(lin -> {
                    isKey.getAndSet(!isKey.get());
                    if (isKey.get()) {
                        key.set(lin);
                    } else {
                        val.set(lin);
                        try {
                            String str = String.format("%1$-" + 20 + "s", key) + "  ➤" + lin + lineSeparator;
                            System.out.print(str);
                            bufferedWriter.write(str);
                        } catch (IOException e) {
                            log.error(e.getMessage(),e);
                        }
                    }
                });
            }
        }
        System.out.println("FINISH");
    }


}
