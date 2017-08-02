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
Feature: Realizar el proceso de compra de vuelos desde la web Demo

Background:
		Given Teniendo que soy un cliente
		When inicio mi sesion en la web
			And ingreso mi usuario "tutorial"
			And ingreso mi password "tutorial"
		Then doy click en el boton de ingreso
			And Ingreso a la pagina web

@tag1
Scenario: Un usuario realiza una compra de vuelo 
Given ingreso a la seccion de compra de vuelos
When busco vuelos disponibles para mi destino 
	And selecciono los vuelos que me interesan
	And completo los datos obligatorios para el vuelo 
Then confirmo el vuelo
	And verifico que se haya generado mi vuelo