#!/usr/bin/env bash
set -euo pipefail

gcc -o libvolk.so -shared volk/volk.c
