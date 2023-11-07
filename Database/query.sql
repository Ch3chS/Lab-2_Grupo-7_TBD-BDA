SELECT emergency.*
FROM "voluntary"
JOIN "region" ON ST_Within(voluntary."location", region."geom")
JOIN "emergency" ON ST_Within(emergency."location", region."geom")
WHERE voluntary."rut" = '34567890-1';