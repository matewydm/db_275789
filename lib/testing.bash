#!/bin/bash

function test_out {
  local prefix="$1"
  local cmd="$2"
  local cin="$3"
  local ref="$4"
  local bin_name=$(basename "$cmd")
  echo "[$prefix] $bin_name <<< '$cin'"
  . <({ cerr=$({ cout=$("$cmd" <<< "$cin"); } 2>&1; declare -p cout >&2); declare -p cerr; } 2>&1)
  if [ "$cerr" ]; then
    local result_text="$cerr"
    local result_prefix="[$prefix] 2>"
    local passed=1
  else
    local result_text="$cout"
    local result_prefix="[$prefix] >"
    [ "$cout" == "$ref" ]
    local passed=$?
  fi
  while read line; do
    echo "$result_prefix $line"
  done <<< "$result_text"
  return $passed
}

function test_err {
  local prefix="$1"
  local cmd="$2"
  local cin="$3"
  local ref="$4"
  local bin_name=$(basename "$cmd")
  echo "[$prefix] $bin_name <<< '$cin'"
  . <({ cerr=$({ cout=$("$cmd" <<< "$cin"); } 2>&1; declare -p cout >&2); declare -p cerr; } 2>&1)
  if [ "$cerr" ]; then
    local result_text="$cerr"
    local result_prefix="[$prefix] 2>"
    [[ "$cerr" == *"$ref"* ]]
    local passed=$?
  else
    local result_text="$cout"
    local result_prefix="[$prefix] >"
    local passed=1
  fi
  while read line; do
    echo "$result_prefix $line"
  done <<< "$result_text"
  return $passed
}
