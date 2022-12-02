# Ecosystem-Java
Projet pour la **Sorbonne Université**, *en Programmation orientée Objet (PPO)*

# Générer sources.txt
*En local uniquement...*

### Windows
:page_with_curl: 
```powershell
dir src /b /s *.java > sources.txt
```

### Linux
:page_with_curl: 
```powershell
find ./src/ -type f -name "*.java" > sources.txt
```

# Compilation
#### Générer un ou plusieurs fichier spécifique
:computer: 
```powershell
javac -d bin -cp class path/to/source
```

#### Générer le projet
:computer: 
```powershell
javac -d bin -cp class @sources.txt
```
*Confère Générer sources.txt*