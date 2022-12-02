# Ecosystem-Java
Projet pour la **Sorbonne Université**, *en Programmation orientée Objet (PPO)*

# Générer sources.txt
*En local uniquement...*

### Windows
```powershell
dir src /b /s *.java > sources.txt
```

### Linux
```powershell
find ./src/ -type f -name "*.java" > sources.txt
```

# Compilation
#### Générer un ou plusieurs fichier spécifique
```powershell
javac -d bin -cp class path/to/source
```

#### Générer le projet
```powershell
javac -d bin -cp class @sources.txt
```
*Confère Générer sources.txt*