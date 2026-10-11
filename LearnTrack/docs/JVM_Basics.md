#### 2. `docs/JVM_Basics.md`

```markdown
# JVM, JRE, and JDK Basics

## What is JDK, JRE, and JVM?
- **JDK (Java Development Kit):** The complete software development toolset required to write, compile, and debug Java applications. It includes the compiler (`javac`), libraries, and the JRE.
- **JRE (Java Runtime Environment):** A subset of the JDK that provides the minimum libraries, class loaders, and the JVM necessary to run existing compiled Java programs.
- **JVM (Java Virtual Machine):** The core execution engine that loads Java bytecode and translates it into machine-specific instructions that your specific operating system can execute.

## What is Bytecode?
When you compile human-readable Java source code (`.java` files) using `javac`, the compiler translates it into an intermediate, platform-independent format called **bytecode** (`.class` files). Bytecode is not machine code; instead, it is a standardized set of instructions optimized to be executed efficiently by any JVM, regardless of the underlying hardware or operating system.

## What Does "Write Once, Run Anywhere" Mean?
The phrase "Write Once, Run Anywhere" (WORA) highlights Java's platform independence. Because Java source code compiles down to a universal intermediate bytecode rather than OS-specific machine code, developers only need to write and compile their code a single time. 

That exact same bytecode can then be seamlessly transferred and executed on Windows, macOS, or Linux, provided that the target machine has a compatible Java Virtual Machine installed to interpret the bytecode into local machine instructions.