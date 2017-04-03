# Modelo del Domino

![Modelo de dominio](https://github.com/EventSoftGroup/EventSoft/blob/master/Modelo_de_dominio_EventoSoft.jpg)

## Entidades

### Usuario
   - id (integer)
   - email (varchar)
   - nombre (varchar)
   - apellidos (varchar)
   - dirección (varchar)
   - localidad (varchar)
   - provincia (varchar)
   - cod_postal (integer)
   - roll (integer {0: admin, 1: cliente, 2: proveedor, 3: organizador)
   - estado (integer {0: activo, 1: pendiente_validacin, 2: banneado, etc})
   - listado_mensajes (mensaje)
   - listado_valoraciones (valoración)
   - listado_eventos (evento)
   - listado_servicios (servicio) 
   
### Evento
   - id (integer)
   - nombre (varchar)
   - lugar (varchar)
   - categoría (varchar)
   - fecha_hora_inicio (datetime)
   - fecha_hora_fin (datetime)
   - listado_servicios (servicio)
   - listado_participantes (solo texto - no es una entidad)

### Servicio
   - id (integer)
   - tipo (varchar)
   - nombre (varchar)
   - descripción (varchar)
   - fecha_registro (datetime)
   - estado (integer {0: activo, 1: terminado, etc})
   
### Mensaje/notificación 
   - id_usuario_origen (integer)
   - id_usuario_destino (integer)
   - fecha_registro (datetime)
   - id_evento (integer)
   - asunto (varchar)
   - mensaje (varchar)
   - tipo (integer {0: notificacion, 1: mensaje})
   - estado (integer {0: no_visto, 1: visto})
   
### Valoración
   - id_origen (integer)
   - id_destino (integer)
   - fecha_registro (datetime)
   - tipo (integer {0: evento, 1: servicio, 2: organizador})
   - valoración (integer)
   - Texto (varchar)
   
