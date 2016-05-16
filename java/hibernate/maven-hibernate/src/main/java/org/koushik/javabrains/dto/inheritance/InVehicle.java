package org.koushik.javabrains.dto.inheritance;

import javax.persistence.*;

@Entity
@Table(name = "in_vehicle")

/*
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "vehicle_type",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("vehicle")
*/

//added GenerationType.TABLE to fix MappingException (Cannot use identity column key generation)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.JOINED)

public class InVehicle {
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int vehicleId;
    private String vehicleName;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
