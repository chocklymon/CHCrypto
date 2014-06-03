# CHCrypto

Gives access to cryptographic functions not available in command helper.
As of build #2708 of CommandHelper this functionality is included in command helper itself.

## Function Documentation

### HMAC

hmac_md5
string {key, val} Returns the md5 HMAC of the specified string using the provided key.

hmac_sha1
string {key, val} Returns the sha1 HMAC of the specified string using the provided key.

hmac_sha256
string {key, val} Returns the sha256 HMAC of the specified string using the provided key.
