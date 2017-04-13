# Modelo del Domino

![Modelo de dominio](https://github.com/EventSoftGroup/EventSoft/blob/master/Modelo_de_dominio_EventoSoft.jpg)

## Entidades
---

## Usuario
   - id (integer)
   - email (varchar)
   - Password
   - dirección (varchar)
   - localidad (varchar)
   - provincia (varchar)
   - cod_postal (integer)
   - teléfono (integer)
   - estado (integer {0: activo, 1: pendiente_validación, 2: banneado, etc})
   - listado_mensajes (mensaje)
   
### 1- Cliente
   
   - nombre (varchar)
   - apellidos (varchar)
   - listado_valoraciones (valoración)
   - listado_eventos (evento)


### 2- Profesionales
   - Nombre_empresa
   - CIF
   


#### 3- Organizador
   - Lista eventos organiza


#### 3- Proveedor
   - listado_servicios (servicio) 
   - 


---
   
### Evento
   - id (integer)
   - nombre (varchar)
   - ORGANIZADOR
   - lugar (varchar)
   - categoría (varchar)
   - fecha_hora_inicio (datetime)
   - fecha_hora_fin (datetime)
   - listado_SERVICIOS (servicio)
   - listado_participantes (solo texto - no es una entidad)
   - Listado_CLIENTES
   - 

### Servicio
   - id (integer)
   - tipo (varchar)
   - nombre (varchar)
   - descripción (varchar)
   - fecha_registro (datetime)
      
### Mensaje 
   - id_usuario_origen (integer)
   - id_usuario_destino (integer)
   - fecha_registro (datetime)
   - asunto (varchar)
   - mensaje (varchar)
   - estado (integer {0: no_visto, 1: visto})
   
### Valoración
   - id_Cliente_origen (integer)
   - id_Profesional_destino (integer)
   - fecha_registro (datetime)
   - valoración (integer)
   - Texto (varchar)
   
