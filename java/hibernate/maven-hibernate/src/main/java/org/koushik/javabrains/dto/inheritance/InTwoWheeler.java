package org.koushik.javabrains.dto.inheritance;

import javax.persistence.*;

@Entity
@Table(name = "in_twowheeler")

//@DiscriminatorValue("bike")

public class InTwoWheeler extends InVehicle {
    private String SteeringHandle;

    public String getSteeringHandle() {
        return SteeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        SteeringHandle = steeringHandle;
    }
}
