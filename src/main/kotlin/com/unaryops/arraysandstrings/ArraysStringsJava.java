package com.unaryops.arraysandstrings;

public class ArraysStringsJava {
    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        int index;
        int i = 0;

        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;

        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }

        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
