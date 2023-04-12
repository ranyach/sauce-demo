Feature: Sauce Demo Test Connexion KO

	@POEI23-384 @KO
	Scenario Outline: Sauce Demo Test Connexion KO
		Given Je ouvre la page de authentification
		When  Je saisis le "<Username>" dans le champs Username
		And Je saisis le "<Password>" dans le champs Password
		And Je clique sur le bouton Login
		Then Je verifie l echec de connexion
		And Je verifie l affcihage du message d erreur "<Msg-error>"
		
		Examples:
				| Username        | Password      | Msg-error|
				| rania_user      | secret_sauce  | Epic sadface: Username and password do not match any user in this service|
				| locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out.|
