Feature: Sauce Demo Test Connexion OK [elarbi]


	@TNR @tag2 @DEV
	Scenario Outline: Sauce Demo Test Connexion OK [elarbi]
		Given Je ouvre la page de authentification
		When Je saisis le "<Username>" dans le champs Username
		And Je saisis le "<Password>" dans le champs Password
		And Je clique sur le bouton Login
		Then Authentification avec succès
		
		Examples:
		| Username        | Password     |
		| standard_user   | secret_sauce |
		| locked_out_user | secret_sauce |
