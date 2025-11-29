package de.seuhd.campuscoffee.domain.model;

import lombok.Builder;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Domain record that stores the POS (Point of Sale) metadata.
 * This is an immutable value object - use the builder or toBuilder() to create modified copies.
 * Records provide automatic implementations of equals(), hashCode(), toString(), and accessors.
 * <p>
 * We validate the fields in the API layer based on the DTOs, so no validation annotations are needed here.
 *
 * @param id          the unique identifier; null when the POS has not been created yet
 * @param createdAt   timestamp set on POS creation
 * @param updatedAt   timestamp set on POS creation and update
 * @param name        the name of the POS
 * @param description a description of the POS
 * @param type        the type of POS (cafe, bakery, etc.)
 * @param campus      the campus location
 * @param street      street name
 * @param houseNumber house number (may include suffix such as "21a")
 * @param postalCode  postal code
 * @param city        city name
 */
@Builder(toBuilder = true)
public record Pos(
        @Nullable Long id, // null when the POS has not been created yet
        @Nullable LocalDateTime createdAt, // set on POS creation
        @Nullable LocalDateTime updatedAt, // set on POS creation and update
        @NonNull String name,
        @NonNull String description,
        @NonNull PosType type,
        @NonNull CampusType campus,
        @NonNull String street,
        @NonNull String houseNumber,
        @NonNull Integer postalCode,
        @NonNull String city
) implements Serializable { // serializable to allow cloning (see TestFixtures class).
    @Serial
    private static final long serialVersionUID = 1L;

    //Static null checks
    public Pos{
        java.util.Objects.requireNonNull(name, "name is required");
        java.util.Objects.requireNonNull(description, "description is required");
        java.util.Objects.requireNonNull(type, "type is required");
        java.util.Objects.requireNonNull(campus, "campus is required");
        java.util.Objects.requireNonNull(street, "street is required");
        java.util.Objects.requireNonNull(houseNumber, "houseNumber is required");
        java.util.Objects.requireNonNull(postalCode, "postalCode is required");
        java.util.Objects.requireNonNull(city, "city is required");
    }
}
