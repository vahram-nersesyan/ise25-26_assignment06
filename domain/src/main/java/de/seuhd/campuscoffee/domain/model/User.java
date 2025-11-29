package de.seuhd.campuscoffee.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record User (
        //TODO: Implement user domain object
        @Nullable Long id,
        @Nullable LocalDateTime createdAt,
        @Nullable LocalDateTime updatedAt,
        @NonNull String loginName,
        @NonNull String emailAddress,
        @NonNull String firstName,
        @NonNull String lastName

) implements Serializable { // serializable to allow cloning (see TestFixtures class).
    @Serial
    private static final long serialVersionUID = 1L;
    // Static null checks
    public User{
        java.util.Objects.requireNonNull(loginName, "loginName is required");
        java.util.Objects.requireNonNull(emailAddress, "emailAddress is required");
        java.util.Objects.requireNonNull(firstName, "firstName is required");
        java.util.Objects.requireNonNull(lastName, "lastName is required");
    }
}
