# grepplus
## Summary
grepplus is a simple text search program that accepts one to many keys that are used to search a standard input stream.

## Usage
grepplus is a java program and is invoked using `java grepplus --key [VALUE]`. The text to be
searched must be provided to the standard input stream.

Examples:

Linux/MacOS  
`cat some.file | java grepplus --key some --key text`

Windows  
`type some.file | java grepplus --key some --key text`

## Supported Arguments
* --key [VALUE] - Provides a value for grepplus to search.
* --help - Outputs basic program help documentation.

## Output  
grepplus will output all keys that contain a match, number of matches per key, and the exact position of each match.  

>$ echo hello world | java grepplus --key world  
>Key: world - 1 match(es)  
>  Line: 1 Char: 7

## Enhancements
* Implement support for reading from files instead of just standard input.
