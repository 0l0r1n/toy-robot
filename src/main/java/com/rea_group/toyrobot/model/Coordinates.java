package com.rea_group.toyrobot.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Coordinates {

    @NonNull private int x;
    @NonNull private int y;
}
