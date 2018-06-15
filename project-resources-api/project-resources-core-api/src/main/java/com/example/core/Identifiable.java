package com.example.core;

import java.io.Serializable;
import java.time.Instant;

public interface Identifiable extends Serializable {
	String getDesc();
	String getIdentifier();
	Instant getLastChange();
	String getLongName();
}
