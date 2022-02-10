package com.udacity.vehicles.domain.Car;


import com.udacity.vehicles.domain.Condition;
import com.udacity.vehicles.domain.Location;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@Builder
@EntityListeners(AuditingEntityListener.class)
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Condition condition;


    @Embedded
    private Details details = new Details();


    @Embedded
    private Location location = new Location(0d, 0d);

    @Transient
    private String price;


}
