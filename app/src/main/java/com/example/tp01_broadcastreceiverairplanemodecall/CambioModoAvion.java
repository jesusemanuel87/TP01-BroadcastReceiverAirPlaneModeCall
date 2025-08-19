package com.example.tp01_broadcastreceiverairplanemodecall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class CambioModoAvion extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {
            boolean modoAvion = intent.getBooleanExtra("state", true);

            if (modoAvion) {
                // Modo avión activado
                Toast.makeText(context, "Modo avión activado", Toast.LENGTH_SHORT).show();
                realizarLlamada(context);
            } else {
                // Modo avión desactivado
                Toast.makeText(context, "Modo avión desactivado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void realizarLlamada(Context context){
        try{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:2664553747"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "Error al realizar la llamada", Toast.LENGTH_SHORT).show();
        }
    }
}
