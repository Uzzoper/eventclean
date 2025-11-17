package dev.juan.EventClean.infrastructure.persistence;

import dev.juan.EventClean.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String identifier;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private String location;

    private Integer capacity;

    private String organizer;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType type;
}
