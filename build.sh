#!/usr/bin/env bash
set -euo pipefail

gcc -o libvolk.so -fPIC -shared volk/volk.c -DVK_USE_PLATFORM_XCB_KHR
