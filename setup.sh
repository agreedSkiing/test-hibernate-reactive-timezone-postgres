#!/bin/sh

VSCODE_SETTINGS=$PWD/.vscode/settings.json
VSCODE_EXTENSIONS=$PWD/.vscode/extensions.json

if ! command -v npm &> /dev/null; then
  echo "Missing npm install for setup."
  exit
fi

if ! command -v jq &> /dev/null; then
  echo "Missing jq install for setup."
  exit
fi

if [ ! -d $PWD/.vscode ]; then
  mkdir $PWD/.vscode
fi

if [ ! -f $VSCODE_SETTINGS ]; then
  echo "{}" > $VSCODE_SETTINGS
fi

if [ ! -f $VSCODE_EXTENSIONS ]; then
  echo "{}" > $VSCODE_EXTENSIONS
fi

npm install
cat $VSCODE_SETTINGS | jq -S '. += {"java.configuration.updateBuildConfiguration": "automatic",
  "java.autobuild.enabled": true,
  "java.completion.importOrder": ["#"],
  "java.cleanup.actionsOnSave": [
    "addDeprecated",
    "addFinalModifier",
    "addOverride",
    "instanceofPatternMatch",
    "invertEquals",
    "lambdaExpression",
    "switchExpression",
    "qualifyStaticMembers",
    "qualifyMembers"
  ],
  "java.codeAction.sortMembers.avoidVolatileChanges": true,
  "java.codeGeneration.insertionLocation": "lastMember",
  "java.eclipse.downloadSources": true,
  "java.codeGeneration.hashCodeEquals.useInstanceof": true,
  "java.codeGeneration.hashCodeEquals.useJava7Objects": true,
  "java.codeGeneration.useBlocks": true,
  "java.codeGeneration.toString.codeStyle": "STRING_BUILDER",
  "java.format.enabled": false,
  "editor.formatOnSave": true,
  "editor.formatOnPaste": true,
  "editor.formatOnSaveMode": "file",
  "editor.detectIndentation": false,
  "editor.codeActionsOnSave": { "source.organizeImports": true },
  "editor.defaultFormatter": "esbenp.prettier-vscode"}' | tee $VSCODE_SETTINGS &> /dev/null
cat $VSCODE_EXTENSIONS | jq -S '. += {"recommendations": [
    "esbenp.prettier-vscode",
    "vscjava.vscode-java-dependency",
    "redhat.vscode-quarkus",
    "sonarsource.sonarlint-vscode",
    "vscjava.vscode-java-test",
    "vscjava.vscode-maven",
    "redhat.java",
    "visualstudioexptteam.vscodeintellicode",
    "vscjava.vscode-java-debug"
  ]}' | tee $VSCODE_EXTENSIONS &> /dev/null
