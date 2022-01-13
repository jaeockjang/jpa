#!/bin/bash
SET=$(seq 0 1000)
for i in $SET
do
    echo "Running loop seq "$i
    # some instructions
    http 192.168.64.2:31450/api2/8
done
