package dev.prmts.floorms.floor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;

@Entity
@Table(name = "floor")
@Getter
@Setter
@NoArgsConstructor
public class Floor {
    @Id
    @Column(name = "floor_id")
    @UuidGenerator
    private String id;
    @Column(name = "file_name", unique = true)
    private String fileName;
    @Column(name = "sequence_order", unique = true)
    private Short sequence;
    @Column(name = "name")
    private String name;
    @Column(name = "create_date")
    private OffsetDateTime createDate;
    @Column(name = "update_date")
    private OffsetDateTime updateDate;

    @PrePersist
    protected void onCreate() {
        OffsetDateTime time = OffsetDateTime.now();
        createDate = time;
        updateDate = time;
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = OffsetDateTime.now();
    }

}
