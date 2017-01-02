# ANTLR4-Plugins-for-NetBeans
NetBeans plugins for ANTLR 4 enabling to integrate ANTLR grammar files in standard NetBeans projects (ant-based or Maven-based).

You can consult ANTLR documentation at http://www.antlr.org. ANTLR runtime and complete releases may be recovered on the same web site (but version 4.5.3 is included in plugins 1.0 and version 4.6 in plugin 1.1). ANTLR source code may be recovered at https://github.com/antlr/antlr4. I recommend also the reading of The Definitive ANTLR 4 Reference Guide (https://pragprog.com/book/tpantlr2/the-definitive-antlr-4-reference) written by Terence Parr, the original creator of ANTLR and main contributor with Sam Harwell of ANTLR 4. You can test the plugin with the examples of this book, available at https://pragprog.com/titles/tpantlr2/source_code. It should make clear what this plugin may bring you (test it for instance with the Java grammar).

Documentation of plugin is available in wiki : https://github.com/fredyvonvinet/ANTLR4-Plugins-for-NetBeans/wiki.

For each recent versions of NetBeans (on 10/23/2016: 8.0.2, 8.1, 8.2), you can find a corresponding NetBeans module. Currently, no source modification was required for adapting the plugin to new versions of NetBeans. Nevertheless, there is a different module for each three recent (on 10/17/2016) versions of NetBeans due to change in the location of NetBeans API in terms of modules (diffrent internal module dependencies). So there is only configuration changes between the releases for NetBeans 8.0.2, 8.1 and 8.2.

For deploying ANTLR 4 project resource into a project, select the project where you want to include ANTLR 4 grammar files and select the next menu "File/Add ANTLR support to project". You should see a new report tab in NetBeans output window dedicated to ANTL plugin showing what tasks the plugin has done with success or not.

Currently, the project integration module only supports Java standard Edition project (ant-based or Maven-based). In fact, it is not a limitation because it is a good practice :
- to develop your grammar in such an environment as a simple library project,
- and then, after your grammar has been completely validated, to integrate your new library in your target project (standard edition, Enterprise Edition, etc).
