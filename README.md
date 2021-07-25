# Comment compiler et exécuter l'application Entrevoisins avec Android Studio


## Télécharger l'application Entrevoisins de GitHub

Télecharger dossier avec project en cliquant sur lien >>>
[Code Entrevoisins](https://github.com/maggicco/OC_Project3_Entrevoisins)

Cliquez sur le bouton vert Code sur la droite.

![2021-07-22_21h05_29](https://user-images.githubusercontent.com/28864785/126695341-ba97b4e1-8421-4f2a-9d55-e55190ad27f5.png)


Cliquez sur le bouton Télécharger le ZIP. Le repository va alors être téléchargé sur votre ordinateur sous la forme d'un fichier .Zip.

![2021-07-22_21h06_28](https://user-images.githubusercontent.com/28864785/126695425-a699b7cf-5315-4ffb-ace8-5b610d55fd4d.png)


Ouvrez l'Explorateur de fichiers et accédez au dossier compressé. Pour décompresser l'intégralité du dossier, faites un clic droit pour sélectionner Extraire tout , puis suivez 
les instructions.
Déterminer un emplacement sur votre ordinateur et deplacer dossier décompressé



## Android Studio
1. Téléchargez Android Studio
La première étape est de télécharger le programme d’installation. Il est disponible pour Windows, Mac et Linux, et vous trouverez le lien de téléchargement sur son site officiel 
>>> [Android Studio](https://developer.android.com/studio?hl=fr&gclid=CjwKCAjwruSHBhAtEiwA_qCppumTLFA3BOETqfUdxp5C7jZuHbPqssC4PViPqDSefrMDKHHmekBQpBoCCUYQAvD_BwE&gclsrc=aw.ds)
et cliquez sur le bouton "Télécharger Android Studio".

![2021-07-22_22h28_52](https://user-images.githubusercontent.com/28864785/126705428-d0b805a5-42fe-405d-a8af-c09e3b795880.png)

Dès que c’est fait, cliquez sur le fichier téléchargé pour démarrer l’installation.

### 2. Démarrez l’installation
Android Studio est un outil extrêmement complexe, et il n’y a pas beaucoup de difficulté car sur la plupart des écrans, vous n’avez besoin que de cliquez sur Suivant.

Le seul endroit où vous pouvez avoir des doutes est dans la configuration du RAM maximale à consacrer à l’émulateur Android. 
La configuration recommandée est bien, donc dans cette fenêtre appuyer à nouveau sur Suivant.

### 3. Configuration initiale
La première chose que vous verrez lors de l’ouverture d’Android Studio pour la première fois est un écran comme celui-ci. 
On vous demande juste si vous voulez importer les paramètres d’une version précédente. 
Android Studio détecte généralement les paramètres par lui-même, et si vous n’avez enregistré aucun paramètre précédent, il sera vérifié.
N’importez pas les paramètres ou n’importez pas la configuration.

La fenêtre suivante qui apparaît vous demande l’autorisation de envoyer des données d’utilisation et des statistiques à Google, afin qu’ils puissent être utilisés ²
pour améliorer l’application. C’est complètement optionnel, alors acceptez-le avec Envoyer les statistiques d’utilisation à Google ou non, 
dans ce cas en cliquant sur Ne pas envoyer.
Après cet assistant de préconfiguration, le Assistant de configuration. En vérité, ce ne sont que quelques fenêtres avec les options de configuration les plus importantes et,
dans tous les cas, vous pouvez toujours modifier les paramètres plus tard.

La première chose qui vous est demandée est de savoir si vous voulez installation standard ou personnalisée depuis Android Studio.
Dans la grande majorité des cas, l’installation standard est suffisante et vous fera gagner du temps et des maux de tête occasionnels.
Alors tu dois choisir quel thème utiliserez-vous dans l’éditeur de code. L’usine en apporte deux: le thème Light Light et le thème Darcula dark. Choisissez celui qui vous 
convainc le plus, bien que vous puissiez toujours le modifier plus tard dans les options, ainsi que personnaliser les couleurs et les polices si vous le souhaitez.

### 4. Téléchargez les composants
Android Studio choisit les composants à télécharger pour vous.
Le téléchargement est sécurisé dépasser 950 Mo.
Laissez le PC faire le travail à votre place et attendez la fin du téléchargement et de l’installation. Une fois terminé, appuyez sur Terminer.

### 5. Ouverture d'Android Studio
Android Studio est déjà installé sur votre système et il vous montrera l’écran de bienvenue.

Cliquez sur Open an existing Android Studio project
![2021-07-24_23h00_12](https://user-images.githubusercontent.com/28864785/126889713-406e9972-d57e-4abe-ab88-31825864dd52.png)

Dans la fenetre "Open File or Project" choisissez l'emplacement de dossier avec l'application Entrevoisins et cliquez sur Ok.

![2021-07-24_23h05_37](https://user-images.githubusercontent.com/28864785/126889751-986f65ed-f83c-4098-a2b1-c034252cde0d.png)

Une fois l'application ouvert, vous pouvez exécuter une application à partir d'un projet Android Studio, ou vous pouvez exécuter une application qui a été installée sur 
l'émulateur Android comme vous le feriez pour n'importe quelle application sur un appareil.
Un émulateur Android est un périphérique virtuel qui vous permet de tester vos applications Android dans une variété de périphérique virtuel.Vous pouvez donc créer un émulateur 
pour chaque type de périphérique Android que vous souhaitez supporter. Les émulateur sont créés à partir des configuration des périphériques virtuel android(AVD, Android virtual 
device).

Un périphérique virtuel Android (AVD) est un ensemble de configuration qui définit les caractéristiques d’un périphérique Android spécifique que vous souhaitez simuler dans 
l’émulateur Android .Le AVD Manager est une interface que vous pouvez lancer à partir d’Android Studio et qui vous aide à créer et gérer les AVD.
Guide de l'émulateur - Site officiel Android Studio comment [Créer et gérer des appareils virtuels](https://developer.android.com/studio/run/managing-avds).

 Une fois que votre emulateur est installée, dans le menu déroulant cliquez sur "app".

![2021-07-25_08h01_28](https://user-images.githubusercontent.com/28864785/126889759-695d8a53-ebf2-4231-b49e-902d4021ce11.png)

![2021-07-25_08h03_13](https://user-images.githubusercontent.com/28864785/126889772-a96e4d4a-e4b6-4c2d-a34b-d50fb04f9fbb.png)

Dans le menu déroulant périphérique cible , sélectionnez l’appareil sur lequel vous souhaitez exécuter votre application.

![2021-07-25_08h04_22](https://user-images.githubusercontent.com/28864785/126889799-cadbef53-6b4b-4845-9f7a-b6777528e654.png)

Démarrer l'émulateur Android et exécuter l'application dans votre projet

![2021-07-25_08h22_07](https://user-images.githubusercontent.com/28864785/126889835-3b83b512-b184-4e32-a5f3-45fa8382c68a.png)

L'application vas démarrer sur emulateur et maintenant vous pouvez tester votre application.

![2021-07-25_12h00_47](https://user-images.githubusercontent.com/28864785/126897441-68124315-dd43-4404-808c-01846def7045.png)



Guide Android Studio:
Site officiel Android Studio comment [Exécuter des applications sur l'émulateur Android](https://developer.android.com/studio/run/emulator?gclid=Cj0KCQjwl_SHBhCQARIsAFIFRVXrTsw_HR1Njl0v5cEpFqefj_efTVINL7FOSVmK-oSiOR3xPgXYM_saAr2aEALw_wcB&gclsrc=aw.ds)
