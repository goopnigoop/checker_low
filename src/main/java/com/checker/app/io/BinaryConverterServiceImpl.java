package com.checker.app.io;

public class BinaryConverterServiceImpl implements BinaryConverterService {

    @Override
    public String getBinaryRepresentation(int number) {
        if (number == 0) {
            return "0";
        }
        if (number == 1) {
            return "1";
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            if (number % 2 == 0) {
                stringBuilder.append("0");
            } else {
                stringBuilder.append("1");
            }
            number /= 2;
        }
        return stringBuilder.reverse().toString();
    }
}
