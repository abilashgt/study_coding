package org.koushik.javabrains.dto.inheritance;

import javax.persistence.*;

@Entity
@Table(name = "in_fourwheeler")

//@DiscriminatorValue("car")

public class InFourWheeler extends InVehicle {
    private String SteeringWheel;

    public String getSteeringWheel() {
        return SteeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        SteeringWheel = steeringWheel;
    }
}
