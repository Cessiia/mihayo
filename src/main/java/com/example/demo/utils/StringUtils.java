package com.example.demo.utils;

public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;

    public StringUtils() {
    }

    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(final String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(final String str) {
        return !isBlank(str);
    }

    /** @deprecated */
    public static String clean(final String str) {
        return str == null ? "" : str.trim();
    }

    public static String trim(final String str) {
        return str == null ? null : str.trim();
    }

    public static String trimToNull(final String str) {
        final String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    public static String trimToEmpty(final String str) {
        return str == null ? "" : str.trim();
    }

    public static String strip(final String str) {
        return strip(str, (String) null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        } else {
            str = strip(str, (String) null);
            return str.length() == 0 ? null : str;
        }
    }

    public static String stripToEmpty(final String str) {
        return str == null ? "" : strip(str, (String) null);
    }

    public static String strip(String str, final String stripChars) {
        if (isEmpty(str)) {
            return str;
        } else {
            str = stripStart(str, stripChars);
            return stripEnd(str, stripChars);
        }
    }

    public static String stripStart(final String str, final String stripChars) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            int start = 0;
            if (stripChars == null) {
                while (start != strLen && Character.isWhitespace(str.charAt(start))) {
                    ++start;
                }
            } else {
                if (stripChars.length() == 0) {
                    return str;
                }

                while (start != strLen && stripChars.indexOf(str.charAt(start)) != -1) {
                    ++start;
                }
            }

            return str.substring(start);
        } else {
            return str;
        }
    }

    public static String stripEnd(final String str, final String stripChars) {
        int end;
        if (str != null && (end = str.length()) != 0) {
            if (stripChars == null) {
                while (end != 0 && Character.isWhitespace(str.charAt(end - 1))) {
                    --end;
                }
            } else {
                if (stripChars.length() == 0) {
                    return str;
                }

                while (end != 0 && stripChars.indexOf(str.charAt(end - 1)) != -1) {
                    --end;
                }
            }

            return str.substring(0, end);
        } else {
            return str;
        }
    }

    public static String[] stripAll(final String[] strs) {
        return stripAll(strs, (String) null);
    }

    public static String[] stripAll(final String[] strs, final String stripChars) {
        int strsLen;
        if (strs != null && (strsLen = strs.length) != 0) {
            final String[] newArr = new String[strsLen];

            for (int i = 0; i < strsLen; ++i) {
                newArr[i] = strip(strs[i], stripChars);
            }

            return newArr;
        } else {
            return strs;
        }
    }

    public static boolean equals(final String str1, final String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    public static boolean equalsIgnoreCase(final String str1, final String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }

    public static int indexOf(final String str, final char searchChar) {
        return isEmpty(str) ? -1 : str.indexOf(searchChar);
    }

    public static int indexOf(final String str, final char searchChar, final int startPos) {
        return isEmpty(str) ? -1 : str.indexOf(searchChar, startPos);
    }

    public static int indexOf(final String str, final String searchStr) {
        return str != null && searchStr != null ? str.indexOf(searchStr) : -1;
    }

    public static int ordinalIndexOf(final String str, final String searchStr, final int ordinal) {
        return ordinalIndexOf(str, searchStr, ordinal, false);
    }

    private static int ordinalIndexOf(final String str, final String searchStr, final int ordinal,
            final boolean lastIndex) {
        if (str != null && searchStr != null && ordinal > 0) {
            if (searchStr.length() == 0) {
                return lastIndex ? str.length() : 0;
            } else {
                int found = 0;
                int index = lastIndex ? str.length() : -1;

                do {
                    if (lastIndex) {
                        index = str.lastIndexOf(searchStr, index - 1);
                    } else {
                        index = str.indexOf(searchStr, index + 1);
                    }

                    if (index < 0) {
                        return index;
                    }

                    ++found;
                } while (found < ordinal);

                return index;
            }
        } else {
            return -1;
        }
    }

    public static int indexOf(final String str, final String searchStr, final int startPos) {
        if (str != null && searchStr != null) {
            return searchStr.length() == 0 && startPos >= str.length() ? str.length()
                    : str.indexOf(searchStr, startPos);
        } else {
            return -1;
        }
    }

    public static int indexOfIgnoreCase(final String str, final String searchStr) {
        return indexOfIgnoreCase(str, searchStr, 0);
    }

    public static int indexOfIgnoreCase(final String str, final String searchStr, int startPos) {
        if (str != null && searchStr != null) {
            if (startPos < 0) {
                startPos = 0;
            }

            final int endLimit = str.length() - searchStr.length() + 1;
            if (startPos > endLimit) {
                return -1;
            } else if (searchStr.length() == 0) {
                return startPos;
            } else {
                for (int i = startPos; i < endLimit; ++i) {
                    if (str.regionMatches(true, i, searchStr, 0, searchStr.length())) {
                        return i;
                    }
                }

                return -1;
            }
        } else {
            return -1;
        }
    }

    public static int lastIndexOf(final String str, final char searchChar) {
        return isEmpty(str) ? -1 : str.lastIndexOf(searchChar);
    }

    public static int lastIndexOf(final String str, final char searchChar, final int startPos) {
        return isEmpty(str) ? -1 : str.lastIndexOf(searchChar, startPos);
    }

    public static int lastIndexOf(final String str, final String searchStr) {
        return str != null && searchStr != null ? str.lastIndexOf(searchStr) : -1;
    }

    public static int lastOrdinalIndexOf(final String str, final String searchStr, final int ordinal) {
        return ordinalIndexOf(str, searchStr, ordinal, true);
    }

    public static int lastIndexOf(final String str, final String searchStr, final int startPos) {
        return str != null && searchStr != null ? str.lastIndexOf(searchStr, startPos) : -1;
    }

    public static int lastIndexOfIgnoreCase(final String str, final String searchStr) {
        return str != null && searchStr != null ? lastIndexOfIgnoreCase(str, searchStr, str.length()) : -1;
    }

    public static int lastIndexOfIgnoreCase(final String str, final String searchStr, int startPos) {
        if (str != null && searchStr != null) {
            if (startPos > str.length() - searchStr.length()) {
                startPos = str.length() - searchStr.length();
            }

            if (startPos < 0) {
                return -1;
            } else if (searchStr.length() == 0) {
                return startPos;
            } else {
                for (int i = startPos; i >= 0; --i) {
                    if (str.regionMatches(true, i, searchStr, 0, searchStr.length())) {
                        return i;
                    }
                }

                return -1;
            }
        } else {
            return -1;
        }
    }

    public static boolean contains(final String str, final char searchChar) {
        if (isEmpty(str)) {
            return false;
        } else {
            return str.indexOf(searchChar) >= 0;
        }
    }

    public static boolean contains(final String str, final String searchStr) {
        if (str != null && searchStr != null) {
            return str.indexOf(searchStr) >= 0;
        } else {
            return false;
        }
    }

    public static boolean containsIgnoreCase(final String str, final String searchStr) {
        if (str != null && searchStr != null) {
            final int len = searchStr.length();
            final int max = str.length() - len;

            for (int i = 0; i <= max; ++i) {
                if (str.regionMatches(true, i, searchStr, 0, len)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

}
