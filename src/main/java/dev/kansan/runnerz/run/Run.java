package dev.kansan.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
		@NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
		@Positive
        Integer miles,
        Location location
) {
	public Run {
		if(startedOn.isAfter(completedOn)) {
			throw  new IllegalArgumentException("Completed date must be after started date");
		}
	}
}
