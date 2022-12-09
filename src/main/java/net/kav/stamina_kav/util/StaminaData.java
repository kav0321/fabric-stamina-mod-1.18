package net.kav.stamina_kav.util;

import net.minecraft.nbt.NbtCompound;

public class StaminaData {

    private static float STAMINA=0;
    private static boolean JOIN=false;
    private static float MAXSTAMINA=17;
    private static float RECOVERYRATE;
    public static float  Stamina(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        return nbt.getFloat("Stamina");
    }

    public static boolean  JOIN(IEntityDataSaver player)
    {
        NbtCompound nbt = player.getPersistentData();
        JOIN=nbt.getBoolean("join");
        return JOIN;
    }
    public static boolean  JOIN(IEntityDataSaver player, boolean setjoin)
    {
        NbtCompound nbt = player.getPersistentData();
        JOIN=setjoin;
        nbt.putBoolean("join",JOIN);

        return JOIN;
    }
    public static float addPoints(IEntityDataSaver player, float amount,String string)
    {
        NbtCompound nbt = player.getPersistentData();
        MAXSTAMINA=nbt.getFloat("MaxStamina");
        RECOVERYRATE=nbt.getFloat("recoveryrate");
        //STAMINA=nbt.getFloat("Stamina");
        switch (string) {
            case "Stamina":

                if (STAMINA >= MAXSTAMINA) {
                    STAMINA = MAXSTAMINA;
                }
                else {

                    if(amount==0.8f)
                    {
                        System.out.println(STAMINA);
                    }
                    STAMINA = STAMINA + amount;
                    if(amount==0.8f)
                    {
                        System.out.println(STAMINA);
                    }
                }
                nbt.putFloat("Stamina", STAMINA);
                GlobalStamina.setStamina(STAMINA);
                return STAMINA;
            case "MaxStamina":
                if(MAXSTAMINA>99)
                {
                    MAXSTAMINA=99;
                }
                else if(MAXSTAMINA==0)
                {
                    MAXSTAMINA=15;
                }
                else
                {
                    if(MAXSTAMINA%5==0)
                    {
                        RECOVERYRATE+=0.5;
                    }

                    MAXSTAMINA = MAXSTAMINA + amount;}
                nbt.putFloat("MaxStamina", MAXSTAMINA);
                nbt.putFloat("recoveryrate",RECOVERYRATE);

                return MAXSTAMINA;
            //do nothing for now
            default:
                return 2;
        }
    }

    public static float recoveryratetag(IEntityDataSaver player)
    {
        return 0.0f;
    }

    public static float removePoints(IEntityDataSaver player, float amount,String string)
    {
        NbtCompound nbt = player.getPersistentData();
        //  Stamina=nbt.getFloat("Stamina");
        //Stamina=nbt.getFloat("Stamina");
        MAXSTAMINA=nbt.getFloat("MaxStamina");


        switch (string) {
            case "Stamina":

                if (STAMINA<=0) {
                    STAMINA=0;

                    //ClientPlayNetworking.send(ModMessages.COMMAND2,PacketByteBufs.empty());
                }
                else
                {STAMINA = STAMINA - amount;}

                GlobalStamina.setStamina(STAMINA);
                //  nbt.putFloat("Stamina", Stamina);
                //  synSoul(Stamina, (ServerPlayerEntity) player);
                return STAMINA;
            // synSoul(soul, (ServerPlayerEntity) player);

            //do nothing for now
            default:
                return -1000;
        }
    }

}
