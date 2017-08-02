#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Pruebas gmail 

@tag1
Scenario: Prueba Drag and drop correo gmail 
Given Tengo acceso a una cuenta gmail "kuroro.lider.ryodan" con pass "Colombia1*"
	And redacto un nuevo correo
When Ingreso el destinatario "kuroro.lider.ryodan@gmail.com"
	And ingresar asunto "Caso Prueba" y cuerpo email "Detalle email"
	And enviar correo
Then verificar email en bandeja de entrada "Caso Prueba"
	And eliminar email con click derecho
	And Mover el email nuevamente a la bandeja de entrada
	
#1.	Loguearse en Gmail
#2.	Hacer click en Redactar
#3.	Ingresar el destinatario (la misma cuenta desde la que está redactando el correo)
#4.	Cambiar el foco al campo Asunto
#5.	Ingresar un asunto
#6.	Ingresar el cuerpo de email
#7.	Enviar el correo
#8.	Verificar que está en la bandeja de entrada
#9.	Haciendo click derecho enviarlo a los correo eliminados
#10.	Haciendo drag and drop moverlo nuevamente a la bandeja de entrada

