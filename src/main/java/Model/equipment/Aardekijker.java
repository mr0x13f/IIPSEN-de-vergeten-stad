package Model.equipment;

public class Aardekijker extends Equipment {
	
	/////////////////////////////////////// Constructor ///////////////////////////////////////

	public Aardekijker() {
	
		super( "Aardekijker","Bekijk een niet-uitgegraven tegel", "/placeholder.png", Equipment.EquipmentKaarten.AARDEKIJKER);
        this.equipmentKaart = EquipmentKaarten.AARDEKIJKER;
	}

}
