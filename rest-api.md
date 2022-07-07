- Pfad
- Query Parameter
- Http Verb: GET, POST, PUT, DELETE (HEAD, OPTIONS, PATCH, TRACE)
- Request Body

TIPP: Erstellen einer API-Dokumentation mittels: https://swagger.io


REST: Ressourcen
Produkte
Kunden
Bestellungen


Endpoints:
----------
Lade alle Produkte vom Server: 
GET /api/products

Lade Produkt mit bestimmter ID:
GET /api/products/{id}

Lade Produkte mit bestimmtem Tag:
GET /api/products?tag={tag}

Erzeuge neues Produkt:
POST /api/products

Lösche Produkt:
DELETE /api/products/{id}

Update Produkt:
PUT /api/products/{id}

Füge Tags zu Produkt hinzu:
PUT /api/products/{id}/tags




Update Produktbeschreibung:





Bestelle Produkt --> Erzeuge neue Bestellung:
POST /api/orders




Ändere Preis eines Produkts:
POST /api/updatePrice
