'''
# TP01-BroadcastReceiverAirPlaneModeCall :airplane: :telephone_receiver:

Aplicación Android que demuestra el uso de `BroadcastReceiver` para detectar cambios en el Modo Avión y realizar una acción específica (iniciar una llamada).

## :memo: Descripción del Proyecto

El objetivo principal de esta aplicación es:

1.  **Escuchar cambios del Modo Avión**: Implementa un `BroadcastReceiver` que se activa cuando el estado del Modo Avión del dispositivo cambia.
2.  **Iniciar una llamada**: Al detectar que el Modo Avión ha sido **activado**, la aplicación intenta iniciar una llamada telefónica al número predefinido `2664######`.

## :gear: Funcionalidades Implementadas

*   **`CambioModoAvion.java` (BroadcastReceiver)**:
    *   Escucha la acción `android.intent.action.AIRPLANE_MODE` (o `Intent.ACTION_AIRPLANE_MODE_CHANGED`).
    *   Verifica si el Modo Avión fue activado.
    *   Si se activa, muestra un `Toast` informativo.
    *   Utiliza un `Intent` implícito con `Intent.ACTION_CALL` y el `Uri` `tel:2664553747` para intentar realizar una llamada.
        *   **Nota Importante sobre `ACTION_CALL`**: Esta acción intenta realizar la llamada directamente y requiere el permiso `android.permission.CALL_PHONE`. Si se prefiere solo abrir la aplicación de teléfono con el número marcado (sin iniciar la llamada automáticamente), se debería usar `Intent.ACTION_DIAL`, que no requiere permisos especiales.

*   **`AndroidManifest.xml`**:
    *   Registra el `BroadcastReceiver` (`CambioModoAvion`) con un `<intent-filter>` para la acción `android.intent.action.AIRPLANE_MODE_CHANGED`.
    *   **Permiso Requerido**: Si se utiliza `Intent.ACTION_CALL`, es crucial declarar `<uses-permission android:name="android.permission.CALL_PHONE" />` en el manifiesto.

## :rocket: Cómo Probar

1.  Clona o descarga el proyecto.
2.  Ábrelo en Android Studio.
3.  Asegúrate de que el permiso `CALL_PHONE` esté correctamente declarado en `AndroidManifest.xml` si vas a probar la funcionalidad de llamada directa.
4.  Ejecuta la aplicación en un emulador o dispositivo físico.
5.  Una vez que la aplicación esté instalada (no necesita estar abierta), activa el Modo Avión en el dispositivo.
6.  Deberías ver un mensaje `Toast` indicando "Modo avión activado" y la interfaz de llamada debería intentar iniciarse con el número `2664553747`.

## :warning: Consideraciones

*   **Permisos en Android 6.0+**: Para `Intent.ACTION_CALL`, además de declararlo en el manifiesto, en dispositivos con Android 6.0 (API nivel 23) y superior, necesitarás [solicitar el permiso `CALL_PHONE` en tiempo de ejecución](https://developer.android.com/training/permissions/requesting) para que la llamada se realice correctamente. Este proyecto actualmente no implementa la solicitud de permisos en tiempo de ejecución.
*   **Alternativa Segura (`ACTION_DIAL`)**: Usar `Intent.ACTION_DIAL` en lugar de `Intent.ACTION_CALL` es una alternativa más segura y no requiere permisos especiales. Simplemente abrirá la aplicación de teléfono con el número ya marcado, permitiendo al usuario confirmar la llamada.

---

*Este README fue generado para el proyecto TP01-BroadcastReceiverAirPlaneModeCall.*
'''