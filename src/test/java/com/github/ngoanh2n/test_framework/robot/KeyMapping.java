package com.github.ngoanh2n.test_framework.robot;

import java.util.HashMap;
import java.util.Map;

public class KeyMapping {
    private static final Map<String, Integer> mapping = new HashMap<>();

    static {
        mapping.put(" ", 0x20);
        mapping.put(",", 0x2C);
        mapping.put("_", 0x2D);
        mapping.put(".", 0x2E);
        mapping.put("/", 0x2F);
        mapping.put("\\", 0x5C);
        mapping.put("0", 0x30);
        mapping.put("1", 0x31);
        mapping.put("2", 0x32);
        mapping.put("3", 0x33);
        mapping.put("4", 0x34);
        mapping.put("5", 0x35);
        mapping.put("6", 0x36);
        mapping.put("7", 0x37);
        mapping.put("8", 0x38);
        mapping.put("9", 0x39);
        mapping.put(";", 0x3B);
        mapping.put("=", 0x3D);
        mapping.put("a", 0x41);
        mapping.put("b", 0x42);
        mapping.put("c", 0x43);
        mapping.put("d", 0x44);
        mapping.put("e", 0x45);
        mapping.put("f", 0x46);
        mapping.put("g", 0x47);
        mapping.put("h", 0x48);
        mapping.put("i", 0x49);
        mapping.put("j", 0x4A);
        mapping.put("k", 0x4B);
        mapping.put("l", 0x4C);
        mapping.put("m", 0x4D);
        mapping.put("n", 0x4E);
        mapping.put("o", 0x4F);
        mapping.put("p", 0x50);
        mapping.put("q", 0x51);
        mapping.put("r", 0x52);
        mapping.put("s", 0x53);
        mapping.put("t", 0x54);
        mapping.put("u", 0x55);
        mapping.put("v", 0x56);
        mapping.put("w", 0x57);
        mapping.put("x", 0x58);
        mapping.put("y", 0x59);
        mapping.put("z", 0x5A);
        mapping.put("[", 0x5B);
        mapping.put("]", 0x5D);
        mapping.put("`", 0xC0);
        mapping.put("'", 0xDE);
        mapping.put("@", 0x0200);
        mapping.put(":", 0x0201);
        mapping.put("^", 0x0202);
        mapping.put("$", 0x0203);
        mapping.put("!", 0x0205);
        mapping.put("(", 0x0207);
        mapping.put(")", 0x020A);
        mapping.put("#", 0x0208);
        mapping.put("+", 0x0209);
        mapping.put("-", 0x020B);
    }

    public static int getCharId(char character) {
        return mapping.get(String.valueOf(character));
    }
}
