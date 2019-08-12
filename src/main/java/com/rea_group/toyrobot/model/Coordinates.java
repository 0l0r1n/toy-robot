package com.rea_group.toyrobot.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Coordinates {

    @NonNull @Getter private final int x;
    @NonNull @Getter private final int y;
}
