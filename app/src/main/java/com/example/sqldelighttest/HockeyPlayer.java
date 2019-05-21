package com.example.sqldelighttest;

import com.example.HockeyPlayerModel;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.prerelease.RowMapper;

@AutoValue
public abstract class HockeyPlayer implements HockeyPlayerModel {
    public static final Factory<HockeyPlayer> FACTORY = new Factory<>(AutoValue_HockeyPlayer::new);

    public static final RowMapper<HockeyPlayer> QUERY1_MAPPER = FACTORY.query1Mapper();
}
