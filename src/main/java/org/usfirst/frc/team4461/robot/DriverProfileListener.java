package org.usfirst.frc.team4461.robot;

import edu.wpi.first.networktables.TableEntryListener;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.networktables.NetworkTableEntry;;

public class DriverProfileListener implements TableEntryListener{
    public DriverProfileListener(){

    }

    @Override
    public void valueChanged(NetworkTable table, String key, NetworkTableEntry entry,
                             NetworkTableValue value, int flags){
        
    }
}