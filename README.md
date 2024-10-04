# Project: *se1-play*

The next commit adds [IDE](https://aws.amazon.com/what-is/ide/)
project files.

For the [*Visual Studio Code*](https://code.visualstudio.com/) IDE,
*VSCode project files* are stored in a folder: `.vscode`
in the project directory with files:

- [settings.json](.vscode/settings.json): project-specific VSCode
    configuration,

- [launch.json](.vscode/launch.json): launch and debug configurations,

- [launch_terminal.sh](.vscode/launch_terminal.sh): script to launch
    terminals in VSCode

Project-specific [settings.json](.vscode/settings.json) over-rules
*system-wide* (*global*) settings maintained in the VSCode
installation directory, e.g. on Windows in:
`C:/Users/<user>/AppData/Roaming/Code/User/settings.json`.
VSCode combines both settings.

```sh
<se1-play>              # project directory
 |
 +--.gitignore                  # files for git to ignore
 +-- README.md                  # this markup file
 |
 +-<.vscode>                    # VSCode project files
    +-- settings.json           # project-specific VSCode configuration
    +-- launch.json             # launch and debug configurations
    +-- launch_terminal.sh      # script to launch terminals in VSCode
```
