package com.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum RStatus {
    IsAlive, IsNotAlive, isBuy;
}
